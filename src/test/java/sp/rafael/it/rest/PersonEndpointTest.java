package sp.rafael.it.rest;

import com.example.dao.PersonDAO;
import com.example.model.Person;
import com.example.rest.PersonEndpoint;
import com.jayway.restassured.path.json.JsonPath;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletResponse;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by rafael on 6/27/16.
 */

public class PersonEndpointTest {

    Dispatcher dispatcher;

    POJOResourceFactory noDefaults;
    List<Person> persons;

    @InjectMocks
    PersonEndpoint endpoint;

    @Mock
    PersonDAO dao;

    MockHttpRequest request;
    MockHttpResponse response;

    @BeforeClass
    public void setupClass(){

        MockitoAnnotations.initMocks(this);


        dispatcher = MockDispatcherFactory.createDispatcher();
        noDefaults= new POJOResourceFactory(PersonEndpoint.class);
        dispatcher.getRegistry().addSingletonResource(endpoint);
        //dispatcher.getRegistry().addResourceFactory(noDefaults);
        initPersons();

    }

    @BeforeMethod
    public void setupMethod() throws URISyntaxException {
        response = new MockHttpResponse();
    }


    @Test
    public void shouldGetPersons() throws Exception {

        request = MockHttpRequest.get("/persons");

        when(dao.findAll()).thenReturn(persons);

        dispatcher.invoke(request, response);

        assertEquals(HttpServletResponse.SC_OK, response.getStatus());
        verify(dao,only()).findAll();

    }

    @Test
    public void shouldGetOnlyOnePerson() throws Exception {

        Long pId = Long.valueOf(new Random().nextInt(10000));
        //request.setAttribute("id",pId);
        request = MockHttpRequest.get("/persons/"+pId);

        dispatcher.invoke(request,response);

        JsonPath jsonPath = new JsonPath(response.getContentAsString());
        System.out.println(response.getContentAsString());
        Long id = jsonPath.getLong("id");

        assertEquals(HttpServletResponse.SC_OK, response.getStatus());
        assertNotNull(id);

    }

    private void initPersons(){
        this.persons= new ArrayList<Person>();

        for(int i=0; i<=100; i++){
            persons.add(new Person(Long.valueOf(i),"Person "+i));
        }


    }

}
