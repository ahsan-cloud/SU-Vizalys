package SU.Api;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


import java.util.ArrayList;
import java.util.List;

public class ApiTest {


    static String APIbodyTOkenLOgin;
    static List<Header> headerlist = new ArrayList<Header>();
    static public String token;

    //Header Reusable Variables
    static public String name;
    static public String value;

    static public String headerType = "Content-Type";
    static public String headerMediaType = "application/json";
    //static public String OTPtoken="eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJFdmVyeW9uZSxCVUlMVElOXFxVc2VycyxDT05TT0xFIExPR09OLE5UIEFVVEhPUklUWVxcQXV0aGVudGljYXRlZCBVc2VycyxOVCBBVVRIT1JJVFlcXFRoaXMgT3JnYW5pemF0aW9uLExPQ0FMIiwiVXNlcklkIjoiNzMiLCJVc2VyVHlwZXMiOiJJbnB1dHRlcixWaWV3ZXIiLCJleHAiOjE2MDA4NTQyMzcsImlzcyI6InNtZXNrLmluIiwiYXVkIjoicmVhZGVycyJ9.OgPW7c3n84rAzSQC1MMoObsCMpUheuu1_LwXyPEpYts";

    public ApiTest() {


        RestAssured.baseURI = "http://sutestapi.vizalys.com";


    }

    @Nested
    @DisplayName("SU-Vizalys Api's")
    class Api {


        @Test
        @Order(1)
        public void SU_TokenLogin() {
            System.out.println("----------API_TokenLogIn----------");
            String APIBody = "{ \"email\": \"a@gmail.com\",\n" +
                    "  \"password\": \"H123qwe$%^\"}";

            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
            //headerlist.add(new Header("device-id","1"));
            //headerlist.add(new Header("user-agents","postman"));
            //headerlist.add(new Header("device-type","mobile"));
            //headerlist.add(new Header("license-key","EF834317-1486-48E6-91EC-04D76FF720B8"));
            //headerlist.add(new Header("user-host-name","salman"));
            //headerlist.add(new Header("user-language","English"));
            //headerlist.add(new Header("user-host-address","::::0"));

            Headers headers = new Headers(headerlist);

            System.out.println(headers);


            Response r;

            r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Auth/Login");


            ResponseBody body = r.getBody();
            int statusCode = r.getStatusCode();
            System.out.println(statusCode);
            //


            APIbodyTOkenLOgin = body.asString();    ///I COMMENTED THIS OUT FOR CHECKING response

            //	System.out.println("Response body "+APIbodyTOkenLOgin);


            JSONObject json = new JSONObject(body.asString());
            //json = json.getJSONObject("Model");
            token = json.getString("message");
            System.out.println("checking LoginToken " + token);

            //executOPTWebService();

            //System.out.println("checking apiTokenfromLogin "+APIbodyTOkenLOgin);

            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
            //assertEquals(bodyAsString.contains("Fetched Successful") /*Expected value*/, true /*Actual Value*/);

            //APIbodyTOkenLOgin = body.asString(); 	///I COMMENTED THIS OUT FOR CHECKING response
            //	System.out.println("checking apiTokenfromLogin "+APIbodyTOkenLOgin); ///I COMMENTED THIS OUT FOR CHECKING response
            //	System.out.println("kaam hogaya------"+APIbodyTOkenLOgin);

            //if(bodyAsString.contains("Fetched Successful")==false)
            {
                //		System.out.println(" in iff");
                //	fail("Should not have thrown invalidity");
            }
            //fail("Should not have thrown any exception");
            //	assertEquals(bodyAsString.contains("Fetched Successful") /*Expected value*/, true /*Actual Value*/);
        }


        @Test
        @Order(2)
        public void SU_Post_Users()
        {
            System.out.println("----------***** SU_POST_User *****-----------");


            String APIBody = "{ \"userName\": \"ali\",\n" +
                    "  \"email\": \"ali@gmail.com\",\n" +
                    "  \"password\": \"Loss@123\",\n" +
                    "  \"confirmPassword\": \"Loss@123\",\n" +
                    "  \"userRoles\": [\n" +
                    "    {\n" +
                    "      \"roleName\": \"SuperAdmin\",\n" +
                    "      \"selected\": true\n" +
                    "    }\n" +
                    "  ]}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","salman"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //	headerlist.add(new Header("Authorization","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Auth/Users");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            // Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }

        }


        @Test
        @Order(3)
        public void SU_Get_Users()
        {
            System.out.println("----------***** SU_GET_Users *****-----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","salman"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //	headerlist.add(new Header("Authorization","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw"));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Users");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            // Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }

        }


        @Test
        @Order(4)
        public void SU_Get_Users_ById()
        {
            System.out.println("----------***** SU_GET_Users_ById *****-----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","salman"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //	headerlist.add(new Header("Authorization","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Users/df41e2e4-5a58-4c40-a03d-7f6b9e9bdde8");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            // Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }

        }


        @Test
        @Order(5)
        public void SU_Put_Users_ById()
        {
            System.out.println("----------***** SU_PUT_Users_ById *****-----------");


            String APIBody = "{\"email\": \"ali@gmail.com\",\n" +
                    "  \"userName\": \"ali\",\n" +
                    "  \"userId\": \"79ceeaa0-5567-4a91-b859-a2c3f4f85ede\",\n" +
                    "  \"userRoles\": [\n" +
                    "    {\n" +
                    "      \"roleName\": \"SuperAdmin\",\n" +
                    "      \"selected\": true\n" +
                    "    }\n" +
                    "  ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","salman"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //	headerlist.add(new Header("Authorization","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw"));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Auth/Users/df41e2e4-5a58-4c40-a03d-7f6b9e9bdde8");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            // Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }

        }


        @Test
        @Order(6)
        public void SU_Post_Roles()
        {
            System.out.println("----------***** SU_Post_Roles *****----------");


            String APIBody = "{\"roleName\": \"Finance\",\n" +
                    "  \"roleClaims\": [\n" +
                    "    {\n" +
                    "      \"type\": \"string\",\n" +
                    "      \"value\": \"string\",\n" +
                    "      \"selected\": true\n" +
                    "    }\n" +
                    "  ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Auth/Roles");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(7)
        public void SU_Get_AllRoles()
        {
            System.out.println("----------***** SU_Get_AllRoles *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Roles");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        @Test
        @Order(8)
        public void SU_Get_Roles_ById()
        {
            System.out.println("----------***** SU_Get_Roles_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Roles/dfcba2de-2e67-4841-ab4e-f0a7e7ec8958");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(9)
        public void SU_Put_Roles_ById()
        {
            System.out.println("----------***** SU_Put_Roles_ById *****----------");


            String APIBody = "{ \"roleName\": \"Test Role 01\",\n" +
                    "  \"roleClaims\": [\n" +
                    "    {\n" +
                    "      \"type\": \"string\",\n" +
                    "      \"value\": \"string\",\n" +
                    "      \"selected\": true\n" +
                    "    }\n" +
                    "  ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Auth/Roles/e6cbb31b-e9f7-4f0b-8919-958eb9ae9c35");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(10)
        public void SU_Get_AllRolesClaims()
        {
            System.out.println("----------***** SU_Get_AllRolesClaims *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Auth/Claims");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(11)
        public void SU_Post_BusinessPartnerType()
        {
            System.out.println("----------***** SU_Post_BusinessPartnerType *****----------");


            String APIBody = "{\"name\": \"Business Partner 02\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/BusinessPartnerType");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(12)
        public void SU_Get_BusinessPartnerType()
        {
            System.out.println("----------***** SU_Get_BusinessPartnerType *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BusinessPartnerType");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(13)
        public void SU_Get_BusinessPartnerType_ById()
        {
            System.out.println("----------***** SU_Get_BusinessPartnerType_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BusinessPartnerType/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(14)
        public void SU_Put_BusinessPartnerType_ById()
        {
            System.out.println("----------***** SU_Put_BusinessPartnerType_ById *****----------");


            String APIBody = "{\"id\": 59,\n" +
                    "    \"name\": \"Business Partner 02\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/BusinessPartnerType/59");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(15)
        public void SU_Post_BusinessPartners()
        {
            System.out.println("----------***** SU_Post_BusinessPartners *****----------");


            String APIBody = "{\"name\": \"abc\",\n" +
                    "    \"typeId\": 53,\n" +
                    "    \"entityId\": 1,\n" +
                    "    \"address\": \"Y - 7799\",\n" +
                    "    \"cityId\": 2,\n" +
                    "    \"phone\": 654663232,\n" +
                    "    \"mobile\": 453236656163,\n" +
                    "    \"email\": \"a@gmail.com\",\n" +
                    "    \"website\": \"www.a.com\",\n" +
                    "    \"incomeTaxId\": \"04\",\n" +
                    "    \"salesTaxId\": \"02\",\n" +
                    "    \"branch\": \"62\",\n" +
                    "    \"bankName\": \"Hbl\",\n" +
                    "    \"accountTitle\": \"a\",\n" +
                    "    \"accountNumber\": \"6445663231466\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("api/BusinessPartner");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(16)
        public void SU_Get_BusinessPartners()
        {
            System.out.println("----------***** SU_Get_BusinessPartners *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("api/BusinessPartner");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(17)
        public void SU_Get_BusinessPartners_ById()
        {
            System.out.println("----------***** SU_Get_BusinessPartners_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("api/BusinessPartner/13");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(18)
        public void SU_Put_BusinessPartners_ById()
        {
            System.out.println("----------***** SU_Put_BusinessPartners_ById *****----------");


            String APIBody = "{\"id\": 13,\n" +
                    "    \"name\": \"abc\",\n" +
                    "    \"typeId\": 53,\n" +
                    "    \"entityId\": 1,\n" +
                    "    \"address\": \"Y - 7799\",\n" +
                    "    \"cityId\": 2,\n" +
                    "    \"phone\": 654663232,\n" +
                    "    \"mobile\": 453236656163,\n" +
                    "    \"email\": \"a@gmail.com\",\n" +
                    "    \"website\": \"www.a.com\",\n" +
                    "    \"incomeTaxId\": \"04\",\n" +
                    "    \"salesTaxId\": \"02\",\n" +
                    "    \"branch\": \"62\",\n" +
                    "    \"bankName\": \"Hbl\",\n" +
                    "    \"accountTitle\": \"a\",\n" +
                    "    \"accountNumber\": \"6445663231466\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("api/BusinessPartner/13");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(19)
        public void SU_Post_Campus()
        {
            System.out.println("----------***** SU_Post_Campus *****----------");


            String APIBody = "{\"name\": \"Campus 04\",\n" +
                    "    \"cityId\": 1,\n" +
                    "    \"address\": \"Y - 445\",\n" +
                    "    \"organizationId\": 1}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Campus");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(20)
        public void SU_Get_Campus()
        {
            System.out.println("----------***** SU_Get_Campus *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Campus");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(21)
        public void SU_Get_Campus_ById()
        {
            System.out.println("----------***** SU_Get_Campus_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Campus/23");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(22)
        public void SU_Put_Campus_ById()
        {
            System.out.println("----------***** SU_Put_Campus_ById *****----------");


            String APIBody = "{\"id\": 23,\n" +
                    "    \"name\": \"Campus 04\",\n" +
                    "    \"cityId\": 1,\n" +
                    "    \"address\": \"Y - 445\",\n" +
                    "    \"organizationId\": 1}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Campus/23");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(23)
        public void SU_Post_BankAccount()
        {
            System.out.println("----------***** SU_Post_BankAccount *****----------");


            String APIBody = "{ \"accountNumber\": 654842166654,\n" +
                    "    \"bankName\": \"MCB\",\n" +
                    "    \"accountTitle\": \"Farhan\",\n" +
                    "    \"accountType\": 1,\n" +
                    "    \"branch\": \"SMCh\",\n" +
                    "    \"openingBalance\": 850.564,\n" +
                    "    \"currency\": \"PKR\",\n" +
                    "    \"campusId\": 13,\n" +
                    "    \"department\": \"department a\",\n" +
                    "    \"ibnNumber\": \"56\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/BankAccount");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(24)
        public void SU_Put_BankAccount_ById()
        {
            System.out.println("----------***** SU_Put_BankAccount_ById *****----------");


            String APIBody = "{\"id\": 16,\n" +
                    "    \"accountNumber\": 654842166654,\n" +
                    "    \"bankName\": \"MCB\",\n" +
                    "    \"accountTitle\": \"Farhan\",\n" +
                    "    \"accountType\": 1,\n" +
                    "    \"branch\": \"SMCh\",\n" +
                    "    \"openingBalance\": 850.564,\n" +
                    "    \"currency\": \"PKR\",\n" +
                    "    \"campusId\": 13,\n" +
                    "    \"department\": \"department a\",\n" +
                    "    \"ibnNumber\": \"56\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/BankAccount/16");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(25)
        public void SU_Get_BankAccount_ById()
        {
            System.out.println("----------***** SU_Get_BankAccount_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
           // headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BankAccount/16");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(26)
        public void SU_Get_BankAccount()
        {
            System.out.println("----------***** SU_Get_BankAccount *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BankAccount");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(27)
        public void SU_Post_CashAccount()
        {
            System.out.println("----------***** SU_Post_CashAccount *****----------");


            String APIBody = "{\"cashAccountName\": \"Cash Account\",\n" +
                    "    \"handler\": \"Manager\",\n" +
                    "    \"openingBalance\": 450.694,\n" +
                    "    \"currency\": \"PKR\",\n" +
                    "    \"department\": \"Department B\",\n" +
                    "    \"campusId\": 13}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/CashAccount");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(28)
        public void SU_Put_CashAccount()
        {
            System.out.println("----------***** SU_Put_CashAccount *****----------");


            String APIBody = "{ \"id\": 6,\n" +
                    "    \"cashAccountName\": \"Cash Account\",\n" +
                    "    \"handler\": \"Manager\",\n" +
                    "    \"openingBalance\": 450.694,\n" +
                    "    \"currency\": \"PKR\",\n" +
                    "    \"department\": \"Department B\",\n" +
                    "    \"campusId\": 13}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/CashAccount/6");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(29)
        public void SU_Get_CashAccount()
        {
            System.out.println("----------***** SU_Get_CashAccount *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/CashAccount");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(30)
        public void SU_Get_CashAccount_ById()
        {
            System.out.println("----------***** SU_Get_CashAccount_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/CashAccount/6");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(31)
        public void SU_Post_Category()
        {
            System.out.println("----------***** SU_Post_Category *****----------");


            String APIBody = "{\"categoryName\": \"Apparel\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Category");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(32)
        public void SU_Put_Category()
        {
            System.out.println("----------***** SU_Put_Category *****----------");


            String APIBody = "{ \"id\": 1,\n" +
                    "    \"categoryName\": \"Apparel\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Category/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(33)
        public void SU_Get_Category()
        {
            System.out.println("----------***** SU_Get_Category *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Category");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(34)
        public void SU_Get_Category_ById()
        {
            System.out.println("----------***** SU_Get_Category_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Category/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(35)
        public void SU_Post_ItemOrProduct()
        {
            System.out.println("----------***** SU_Post_ItemOrProduct *****----------");


            String APIBody = "{\"productName\": \"Item A\",\n" +
                    "    \"categoryId\": 8,\n" +
                    "    \"salesPrice\": 750.456,\n" +
                    "    \"cost\": 500.56,\n" +
                    "    \"salesTax\": 2}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Product");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(36)
        public void SU_Put_ItemOrProduct()
        {
            System.out.println("----------***** SU_Put_ItemOrProduct *****----------");


            String APIBody = "{ \"id\": 16,\n" +
                    "    \"productName\": \"Item A\",\n" +
                    "    \"categoryId\": 8,\n" +
                    "    \"salesPrice\": 750.456,\n" +
                    "    \"cost\": 500.56,\n" +
                    "    \"salesTax\": 2}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Product/16");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(37)
        public void SU_Get_ItemOrProduct()
        {
            System.out.println("----------***** SU_Get_ItemOrProduct *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Product");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(38)
        public void SU_Get_ItemOrProduct_ById()
        {
            System.out.println("----------***** SU_Get_ItemOrProduct_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Product/16");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(39)
        public void SU_Post_Vehicle()
        {
            System.out.println("----------***** SU_Post_Vehicle *****----------");


            String APIBody = "{ \"businessPartner\": {\n" +
                    "        \"id\": 0,\n" +
                    "        \"name\": \"Vehicle A\",\n" +
                    "        \"typeId\": 1,\n" +
                    "        \"entityId\": 1,\n" +
                    "        \"cityId\": 1,\n" +
                    "        \"address\": \"Sindh University , Jamshoro\",\n" +
                    "        \"mobile\": 65646666623623\n" +
                    "    },\n" +
                    "    \"model\": \"2022\",\n" +
                    "    \"name\": \"Heavy Bike\",\n" +
                    "    \"number\": \"5656\",\n" +
                    "    \"route\": \"ABC\",\n" +
                    "    \"ownerShip\": \"Owned\",\n" +
                    "    \"vehicleType\": \"For Personal Use\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Vehicle");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(40)
        public void SU_Put_Vehicle_ById()
        {
            System.out.println("----------***** SU_Put_Vehicle_ById *****----------");


            String APIBody = "{ \"id\": 1,\n" +
                    "    \"name\": \"Bike\",\n" +
                    "    \"model\": \"2022\",\n" +
                    "    \"number\": \"5656\",\n" +
                    "    \"route\": \"ABC\",\n" +
                    "    \"ownerShip\": \"Owned\",\n" +
                    "    \"vehicleType\": \"For Personal Use\",\n" +
                    "    \"businessPartnerId\": 659115,\n" +
                    "    \"businessPartner\": {\n" +
                    "        \"id\": 0,\n" +
                    "        \"name\": \"Vehicle A\",\n" +
                    "        \"typeId\": 1,\n" +
                    "        \"entityId\": 1,\n" +
                    "        \"cityId\": 1,\n" +
                    "        \"address\": \"Sindh University , Jamshoro\",\n" +
                    "        \"mobile\": \"65646666623623\"\n" +
                    "    } }";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Vehicle/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(41)
        public void SU_Get_Vehicle()
        {
            System.out.println("----------***** SU_Get_Vehicle *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Vehicle");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(42)
        public void SU_Get_Vehicle_ById()
        {
            System.out.println("----------***** SU_Get_Vehicle_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Vehicle/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(43)
        public void SU_Post_Country()
        {
            System.out.println("----------***** SU_Post_Country *****----------");


            String APIBody = "{\"name\": \"Sri Lanka\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Country");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(44)
        public void SU_Put_Country()
        {
            System.out.println("----------***** SU_Put_Country *****----------");


            String APIBody = "{ \"id\":2,\n" +
                    "   \"name\": \"Sri Lanka\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Country/2");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(45)
        public void SU_Get_Country()
        {
            System.out.println("----------***** SU_Get_Country *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Country");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(46)
        public void SU_Get_Country_ById()
        {
            System.out.println("----------***** SU_Get_Country_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Country/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(47)
        public void SU_Post_State()
        {
            System.out.println("----------***** SU_Post_State *****----------");


            String APIBody = "{\"name\": \"Balochistan\",\n" +
                    "    \"countryId\": 1}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/State");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(48)
        public void SU_Put_State()
        {
            System.out.println("----------***** SU_Put_State *****----------");


            String APIBody = "{\"id\": 1,\n" +
                    "    \"name\": \"Balochistan\",\n" +
                    "    \"countryId\": 1}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/State/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(49)
        public void SU_Get_State()
        {
            System.out.println("----------***** SU_Get_State *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/State");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(50)
        public void SU_Get_State_ById()
        {
            System.out.println("----------***** SU_Get_State_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/State/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(51)
        public void SU_Post_City()
        {
            System.out.println("----------***** SU_Post_City *****----------");


            String APIBody = "{\"name\": \"Nawabshah\",\n" +
                    "    \"stateId\": 3}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/City");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(52)
        public void SU_Put_City()
        {
            System.out.println("----------***** SU_Put_City *****----------");


            String APIBody = "{\"id\": 1,\n" +
                    "    \"name\": \"Nawabshah\",\n" +
                    "    \"stateId\": 3}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/City/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(53)
        public void SU_Get_City()
        {
            System.out.println("----------***** SU_Get_City *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/City");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(54)
        public void SU_Get_City_ById()
        {
            System.out.println("----------***** SU_Get_City_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/City/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //Issue in this API
        @Test
        @Order(55)
        public void SU_Post_JournalEntry()
        {
            System.out.println("----------***** SU_Post_JournalEntry *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/JournalEntry");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //Issue in this API
        @Test
        @Order(56)
        public void SU_Put_JournalEntry()
        {
            System.out.println("----------***** SU_Put_JournalEntry *****----------");


            String APIBody = "{\"campus\": \"Thatta Branch\",\n" +
                    "    \"status\": \"Draft\",\n" +
                    "    \"state\": 0,\n" +
                    "    \"totalDebit\": 14000,\n" +
                    "    \"totalCredit\": 14000,\n" +
                    "    \"journalEntryLines\": [\n" +
                    "        {\n" +
                    "            \"account\": \"dd4ab05f-c90e-443d-1953-08d966d526e2\",\n" +
                    "            \"businessPartnerId\": null,\n" +
                    "            \"description\": \"ADVANCE TO EMPLOYEES Testing\",\n" +
                    "            \"debit\": 2000,\n" +
                    "            \"credit\": 0\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"account\": \"dd4ab05f-c90e-443d-1953-08d966d526e2\",\n" +
                    "            \"businessPartnerId\": null,\n" +
                    "            \"description\": \"ADVANCE TO EMPLOYEES Testing\",\n" +
                    "            \"debit\": 3000,\n" +
                    "            \"credit\": 0\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"account\": \"dd4ab05f-c90e-443d-1953-08d966d526e2\",\n" +
                    "            \"businessPartnerId\": null,\n" +
                    "            \"description\": \"ADVANCE TO EMPLOYEES Testing\",\n" +
                    "            \"debit\": 4000,\n" +
                    "            \"credit\": 0\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"account\": \"dd4ab05f-c90e-443d-1953-08d966d526e2\",\n" +
                    "            \"businessPartnerId\": null,\n" +
                    "            \"description\": \"ADVANCE TO EMPLOYEES Testing\",\n" +
                    "            \"debit\": 5000,\n" +
                    "            \"credit\": 0\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"account\": \"53436bda-daf7-4ce8-fc33-08d971d07563\",\n" +
                    "            \"businessPartnerId\": null,\n" +
                    "            \"description\": \"Payable against advance\",\n" +
                    "            \"debit\": 0,\n" +
                    "            \"credit\": 14000\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \n" +
                    "    \"id\": 31,\n" +
                    "    \"docNo\": \"JV-031\",\n" +
                    "    \"date\": \"2021-12-24\",\n" +
                    "    \"description\": \"tes\",\n" +
                    "    \"campusId\": 12,\n" +
                    "    \"statusId\": 1,\n" +
                    "    \"transactionId\": null,\n" +
                    "    \"transactions\": null,\n" +
                    "    \"createdDate\": null,\n" +
                    "    \"modifiedDate\": null,\n" +
                    "    \"createdBy\": null,\n" +
                    "    \"modifiedBy\": null,\n" +
                    "    \"isDelete\": false,\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/JournalEntry/31");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(57)
        public void SU_Get_JournalEntry()
        {
            System.out.println("----------***** SU_Get_JournalEntry *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/JournalEntry");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(58)
        public void SU_Get_JournalEntry_ById()
        {
            System.out.println("----------***** SU_Get_JournalEntry_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/JournalEntry/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(59)
        public void SU_Post_Invoice()
        {
            System.out.println("----------***** SU_Post_Invoice *****----------");


            String APIBody = "{  \"businessPartnerId\": 129090,\n" +
                    "    \"campusId\": 11,\n" +
                    "    \"invoiceDate\": \"2022-04-22\",\n" +
                    "    \"dueDate\": \"2022-04-23\",\n" +
                    "    \"contact\": \"054465656\",\n" +
                    "    \"accountReceivableId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\",\n" +
                    "    \"status\": \"\",\n" +
                    "    \"invoiceLines\": [\n" +
                    "        {\n" +
                    "            \"description\": \"sss\",\n" +
                    "            \"amount\": 450.456,\n" +
                    "            \"accountId\": \"188867f5-5434-4b2a-b91d-08d966caf67d\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"description\": \"ddd\",\n" +
                    "            \"amount\": 560.456,\n" +
                    "            \"accountId\": \"aa90b421-498b-4ace-4acc-08d97c2b5d51\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Invoice");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(60)
        public void SU_Put_Invoice()
        {
            System.out.println("----------***** SU_Put_Invoice *****----------");


            String APIBody = "{\"id\": 57,\n" +
                    "    \"businessPartnerId\": 129090,\n" +
                    "    \"campusId\": 11,\n" +
                    "    \"invoiceDate\": \"2022-04-22\",\n" +
                    "    \"dueDate\": \"2022-04-23\",\n" +
                    "    \"contact\": \"054465656\",\n" +
                    "    \"accountReceivableId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\",\n" +
                    "    \"status\": \"\",\n" +
                    "    \"invoiceLines\": [\n" +
                    "        {\n" +
                    "            \"description\": \"sss\",\n" +
                    "            \"amount\": 450.456,\n" +
                    "            \"accountId\": \"188867f5-5434-4b2a-b91d-08d966caf67d\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"description\": \"ddd\",\n" +
                    "            \"amount\": 560.456,\n" +
                    "            \"accountId\": \"aa90b421-498b-4ace-4acc-08d97c2b5d51\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Invoice/57");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(61)
        public void SU_Get_Invoice()
        {
            System.out.println("----------***** SU_Get_Invoice *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Invoice");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(62)
        public void SU_Get_Invoice_ById()
        {
            System.out.println("----------***** SU_Get_Invoice_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            headerlist.add(new Header("Content-Type","application/json"));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Invoice/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(63)
        public void SU_Get_Invoice_AgingReport()
        {
            System.out.println("----------***** SU_Get_Invoice_AgingReport *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Invoice/getAgingReport");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(64)
        public void SU_Post_CreditNote()
        {
            System.out.println("----------***** SU_Post_CreditNote *****----------");


            String APIBody = "{  \"businessPartnerId\": 659111,\n" +
                    "    \"campusId\": 13,\n" +
                    "    \"noteDate\": \"2022-04-22\",\n" +
                    "    \"accountReceivableId\": \"f1339a45-9b91-4149-8d38-08d96146be23\",\n" +
                    "    \"creditNoteLines\": [\n" +
                    "        {\n" +
                    "            \"description\": \"ggg\",\n" +
                    "            \"accountId\": \"548b8673-5b99-45bf-db3c-08d95e2881ed\",\n" +
                    "            \"amount\": 850.478\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"description\": \"lll\",\n" +
                    "            \"accountId\": \"188867f5-5434-4b2a-b91d-08d966caf67d\",\n" +
                    "            \"amount\": 540.598\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"invoiceTransactionId\": null,\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/CreditNote");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(65)
        public void SU_Put_CreditNote()
        {
            System.out.println("----------***** SU_Put_CreditNote *****----------");


            String APIBody = "{ \"id\": 62,\n" +
                    "    \"businessPartnerId\": 659111,\n" +
                    "    \"campusId\": 13,\n" +
                    "    \"noteDate\": \"2022-04-22\",\n" +
                    "    \"accountReceivableId\": \"f1339a45-9b91-4149-8d38-08d96146be23\",\n" +
                    "    \"creditNoteLines\": [\n" +
                    "        {\n" +
                    "            \"description\": \"ggg\",\n" +
                    "            \"accountId\": \"548b8673-5b99-45bf-db3c-08d95e2881ed\",\n" +
                    "            \"amount\": 850.478\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"description\": \"lll\",\n" +
                    "            \"accountId\": \"188867f5-5434-4b2a-b91d-08d966caf67d\",\n" +
                    "            \"amount\": 540.598\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"invoiceTransactionId\": null,\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/CreditNote/62");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(66)
        public void SU_Get_CreditNote()
        {
            System.out.println("----------***** SU_Get_CreditNote *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/CreditNote");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(67)
        public void SU_Get_CreditNote_ById()
        {
            System.out.println("----------***** SU_Get_CreditNote_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/CreditNote/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(68)
        public void SU_Post_VendorBill()
        {
            System.out.println("----------***** SU_Post_VendorBill *****----------");


            String APIBody = "{ \"vendorId\": 659111,\n" +
                    "    \"vendorBillRef\": \"146\",\n" +
                    "    \"billDate\": \"2022-04-22\",\n" +
                    "    \"dueDate\": \"2022-04-23\",\n" +
                    "    \"status\": \"\",\n" +
                    "    \"currency\": \"PKR\",\n" +
                    "    \"accountPayableId\": \"188867f5-5434-4b2a-b91d-08d966caf67d\",\n" +
                    "    \"campusId\": 13,\n" +
                    "    \"billLines\": [\n" +
                    "        {\n" +
                    "            \"itemId\": 5,\n" +
                    "            \"description\": \"hhh\",\n" +
                    "            \"cost\": 20500.75,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"tax\": 5,\n" +
                    "            \"accountId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"itemId\": 2,\n" +
                    "            \"description\": \"eee\",\n" +
                    "            \"cost\": 10000,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"tax\": 10,\n" +
                    "            \"accountId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Bill");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(69)
        public void SU_Put_VendorBill()
        {
            System.out.println("----------***** SU_Put_VendorBill *****----------");


            String APIBody = "{  \"id\": 47,\n" +
                    "    \"vendorId\": 659111,\n" +
                    "    \"vendorBillRef\": \"146\",\n" +
                    "    \"billDate\": \"2022-04-22\",\n" +
                    "    \"dueDate\": \"2022-04-23\",\n" +
                    "    \"status\": \"\",\n" +
                    "    \"currency\": \"PKR\",\n" +
                    "    \"accountPayableId\": \"188867f5-5434-4b2a-b91d-08d966caf67d\",\n" +
                    "    \"campusId\": 13,\n" +
                    "    \"billLines\": [\n" +
                    "        {\n" +
                    "            \"itemId\": 5,\n" +
                    "            \"description\": \"hhh\",\n" +
                    "            \"cost\": 20500.75,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"tax\": 5,\n" +
                    "            \"accountId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"itemId\": 2,\n" +
                    "            \"description\": \"eee\",\n" +
                    "            \"cost\": 10000,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"tax\": 10,\n" +
                    "            \"accountId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Bill/47");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(70)
        public void SU_Get_VendorBill()
        {
            System.out.println("----------***** SU_Get_VendorBill *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Bill");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(71)
        public void SU_Get_VendorBill_ById()
        {
            System.out.println("----------***** SU_Get_VendorBill_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Bill/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(72)
        public void SU_Get_VendorBill_AgingReport()
        {
            System.out.println("----------***** SU_Get_VendorBill_AgingReport *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Bill/getAgingReport");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(73)
        public void SU_Post_DebitNote()
        {
            System.out.println("----------***** SU_Post_DebitNote *****----------");


            String APIBody = "{ \"vendorId\": 930,\n" +
                    "    \"vendorBillRef\": \"545\",\n" +
                    "    \"noteDate\": \"2022-04-22\",\n" +
                    "    \"campusId\": 12,\n" +
                    "    \"billTransactionId\": null,\n" +
                    "    \"accountPayableId\": \"548b8673-5b99-45bf-db3c-08d95e2881ed\",\n" +
                    "    \"debitNoteLines\": [\n" +
                    "        {\n" +
                    "            \"itemId\": 6,\n" +
                    "            \"description\": \"fff\",\n" +
                    "            \"cost\": 28500.69,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"tax\": 5,\n" +
                    "            \"accountId\": \"f1339a45-9b91-4149-8d38-08d96146be23\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"itemId\": 1,\n" +
                    "            \"description\": \"vvv\",\n" +
                    "            \"cost\": 20000,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"tax\": 10,\n" +
                    "            \"accountId\": \"80d4b7c8-fece-4d55-b5f2-08d963a4f354\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/DebitNote");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(74)
        public void SU_Put_DebitNote()
        {
            System.out.println("----------***** SU_Put_DebitNote *****----------");


            String APIBody = "{\"id\": 34,\n" +
                    "    \"vendorId\": 930,\n" +
                    "    \"vendorBillRef\": \"545\",\n" +
                    "    \"noteDate\": \"2022-04-22\",\n" +
                    "    \"campusId\": 12,\n" +
                    "    \"billTransactionId\": null,\n" +
                    "    \"accountPayableId\": \"548b8673-5b99-45bf-db3c-08d95e2881ed\",\n" +
                    "    \"debitNoteLines\": [\n" +
                    "        {\n" +
                    "            \"itemId\": 6,\n" +
                    "            \"description\": \"fff\",\n" +
                    "            \"cost\": 28500.69,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"tax\": 5,\n" +
                    "            \"accountId\": \"f1339a45-9b91-4149-8d38-08d96146be23\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"itemId\": 1,\n" +
                    "            \"description\": \"vvv\",\n" +
                    "            \"cost\": 20000,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"tax\": 10,\n" +
                    "            \"accountId\": \"80d4b7c8-fece-4d55-b5f2-08d963a4f354\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/DebitNote/34");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(75)
        public void SU_Get_DebitNote()
        {
            System.out.println("----------***** SU_Get_DebitNote *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/DebitNote");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(76)
        public void SU_Get_DebitNote_ById()
        {
            System.out.println("----------***** SU_Get_DebitNote_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/DebitNote/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(77)
        public void SU_Post_Payment()
        {
            System.out.println("----------***** SU_Post_Payment *****----------");


            String APIBody = "{  \"PaymentRegisterType\": 2,\n" +
                    "    \"paymentType\": 2,\n" +
                    "    \"businessPartnerId\": 152,\n" +
                    "    \"accountId\": \"53436bda-daf7-4ce8-fc33-08d971d07563\",\n" +
                    "    \"paymentDate\": \"2022-04-22\",\n" +
                    "    \"paymentRegisterId\": \"9b4a9386-d95b-4612-b5f6-08d963a4f354\",\n" +
                    "    \"description\": \"abc\",\n" +
                    "    \"grossPayment\": 850.478,\n" +
                    "    \"campusId\": 11,\n" +
                    "    \"reference\": \"5665\",\n" +
                    "    \"discount\": 0,\n" +
                    "    \"salesTax\": 6,\n" +
                    "    \"incomeTax\": 7,\n" +
                    "    \"documentTransactionId\": null,\n" +
                    "    \"sst\": 5,\n" +
                    "    \"isSubmit\": 0,\n" +
                    "    \"paymentFormType\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Payment");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(78)
        public void SU_Put_Payment()
        {
            System.out.println("----------***** SU_Put_Payment *****----------");


            String APIBody = "{\"id\": 1252,\n" +
                    "    \"PaymentRegisterType\": 2,\n" +
                    "    \"paymentType\": 2,\n" +
                    "    \"businessPartnerId\": 152,\n" +
                    "    \"accountId\": \"53436bda-daf7-4ce8-fc33-08d971d07563\",\n" +
                    "    \"paymentDate\": \"2022-04-22\",\n" +
                    "    \"paymentRegisterId\": \"9b4a9386-d95b-4612-b5f6-08d963a4f354\",\n" +
                    "    \"description\": \"abc\",\n" +
                    "    \"grossPayment\": 850.478,\n" +
                    "    \"campusId\": 11,\n" +
                    "    \"reference\": \"5665\",\n" +
                    "    \"discount\": 0,\n" +
                    "    \"salesTax\": 6,\n" +
                    "    \"incomeTax\": 7,\n" +
                    "    \"documentTransactionId\": null,\n" +
                    "    \"sst\": 5,\n" +
                    "    \"isSubmit\": 0,\n" +
                    "    \"paymentFormType\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Payment/1252");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(79)
        public void SU_Get_Payment()
        {
            System.out.println("----------***** SU_Get_Payment *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
           //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Payment");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(80)
        public void SU_Get_Payment_ById()
        {
            System.out.println("----------***** SU_Get_Payment_ById  ****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Payment/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(81)
        public void SU_Post_ExternalReceipt()
        {
            System.out.println("----------***** SU_Post_ExternalReceipt *****----------");


            String APIBody = "{ \"PaymentRegisterType\": 1,\n" +
                    "    \"paymentType\": 2,\n" +
                    "    \"businessPartnerId\": 153,\n" +
                    "    \"accountId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\",\n" +
                    "    \"paymentDate\": \"2022-04-22\",\n" +
                    "    \"paymentRegisterId\": \"6511f8e8-9a6d-4355-ec28-08d9a4f27fb5\",\n" +
                    "    \"description\": \"hhh\",\n" +
                    "    \"grossPayment\": 1150.456,\n" +
                    "    \"campusId\": 8,\n" +
                    "    \"reference\": \"256\",\n" +
                    "    \"discount\": 0,\n" +
                    "    \"salesTax\": 0,\n" +
                    "    \"incomeTax\": 0,\n" +
                    "    \"documentTransactionId\": null,\n" +
                    "    \"sst\": 10,\n" +
                    "    \"isSubmit\": 0,\n" +
                    "    \"paymentFormType\": 6}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/ExternalReceipt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(82)
        public void SU_Put_ExternalReceipt()
        {
            System.out.println("----------***** SU_Put_ExternalReceipt *****----------");


            String APIBody = "{ \"id\": 1253,\n" +
                    "    \"PaymentRegisterType\": 1,\n" +
                    "    \"paymentType\": 2,\n" +
                    "    \"businessPartnerId\": 153,\n" +
                    "    \"accountId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\",\n" +
                    "    \"paymentDate\": \"2022-04-22\",\n" +
                    "    \"paymentRegisterId\": \"6511f8e8-9a6d-4355-ec28-08d9a4f27fb5\",\n" +
                    "    \"description\": \"hhh\",\n" +
                    "    \"grossPayment\": 1150.456,\n" +
                    "    \"campusId\": 8,\n" +
                    "    \"reference\": \"256\",\n" +
                    "    \"discount\": 0,\n" +
                    "    \"salesTax\": 0,\n" +
                    "    \"incomeTax\": 0,\n" +
                    "    \"documentTransactionId\": null,\n" +
                    "    \"sst\": 10,\n" +
                    "    \"isSubmit\": 0,\n" +
                    "    \"paymentFormType\": 6}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/ExternalReceipt/1253");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(83)
        public void SU_Get_ExternalReceipt()
        {
            System.out.println("----------***** SU_Get_ExternalReceipt *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/ExternalReceipt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(84)
        public void SU_Get_ExternalReceipt_ById()
        {
            System.out.println("----------***** SU_Get_ExternalReceipt_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/ExternalReceipt/1253");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(85)
        public void SU_Post_InternalReceipt()
        {
            System.out.println("----------***** SU_Post_InternalReceipt *****----------");


            String APIBody = "{ \"PaymentRegisterType\": 1,\n" +
                    "    \"paymentType\": 2,\n" +
                    "    \"businessPartnerId\": 659111,\n" +
                    "    \"accountId\": \"e34c4a3c-5a7b-4dfe-4657-08d9609ed474\",\n" +
                    "    \"paymentDate\": \"2022-04-22\",\n" +
                    "    \"paymentRegisterId\": \"6511f8e8-9a6d-4355-ec28-08d9a4f27fb5\",\n" +
                    "    \"description\": \"fdfd\",\n" +
                    "    \"grossPayment\": 1250.456,\n" +
                    "    \"campusId\": 11,\n" +
                    "    \"reference\": \"5656\",\n" +
                    "    \"discount\": 0,\n" +
                    "    \"salesTax\": 0,\n" +
                    "    \"incomeTax\": 0,\n" +
                    "    \"documentTransactionId\": null,\n" +
                    "    \"sst\": 10,\n" +
                    "    \"isSubmit\": 0,\n" +
                    "    \"paymentFormType\": 8}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/InternalReceipt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(86)
        public void SU_Put_InternalReceipt()
        {
            System.out.println("----------***** SU_Put_InternalReceipt *****----------");


            String APIBody = "{\"id\": 1255,\n" +
                    "    \"PaymentRegisterType\": 1,\n" +
                    "    \"paymentType\": 2,\n" +
                    "    \"businessPartnerId\": 659111,\n" +
                    "    \"accountId\": \"e34c4a3c-5a7b-4dfe-4657-08d9609ed474\",\n" +
                    "    \"paymentDate\": \"2022-04-22\",\n" +
                    "    \"paymentRegisterId\": \"6511f8e8-9a6d-4355-ec28-08d9a4f27fb5\",\n" +
                    "    \"description\": \"fdfd\",\n" +
                    "    \"grossPayment\": 1250.456,\n" +
                    "    \"campusId\": 11,\n" +
                    "    \"reference\": \"5656\",\n" +
                    "    \"discount\": 0,\n" +
                    "    \"salesTax\": 0,\n" +
                    "    \"incomeTax\": 0,\n" +
                    "    \"documentTransactionId\": null,\n" +
                    "    \"sst\": 10,\n" +
                    "    \"isSubmit\": 0,\n" +
                    "    \"paymentFormType\": 8}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/InternalReceipt/1255");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(87)
        public void SU_Get_InternalReceipt()
        {
            System.out.println("----------***** SU_Get_InternalReceipt *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/InternalReceipt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(88)
        public void SU_Get_InternalReceipt_ById()
        {
            System.out.println("----------***** SU_Get_InternalReceipt_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/InternalReceipt/1255");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(89)
        public void SU_Post_BankStatement()
        {
            System.out.println("----------***** SU_Post_BankStatement *****----------");


            String APIBody = "{ \"bankAccountId\": 15,\n" +
                    "    \"description\": \"asd\",\n" +
                    "    \"openingBalance\": 150.465,\n" +
                    "    \"bankStmtLines\": [\n" +
                    "        {\n" +
                    "            \"id\": 0,\n" +
                    "            \"reference\": 56,\n" +
                    "            \"stmtDate\": \"2022-04-24T19:00:00.000Z\",\n" +
                    "            \"label\": \"Label \",\n" +
                    "            \"credit\": 250.456,\n" +
                    "            \"debit\": 0\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"id\": 0,\n" +
                    "            \"reference\": 36,\n" +
                    "            \"stmtDate\": \"2022-04-24T19:00:00.000Z\",\n" +
                    "            \"label\": \"Label\",\n" +
                    "            \"debit\": 100.456,\n" +
                    "            \"credit\": 0\n" +
                    "        }\n" +
                    "    ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/BankStmt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(90)
        public void SU_Put_BankStatement()
        {
            System.out.println("----------***** SU_Put_BankStatement *****----------");


            String APIBody = "{  \"id\": 1027,\n" +
                    "    \"bankAccountId\": 15,  \n" +
                    "    \"description\": \"asd\",\n" +
                    "    \"openingBalance\": 150.47,\n" +
                    "    \"bankStmtLines\": [\n" +
                    "        {\n" +
                    "            \"id\": 7029,\n" +
                    "            \"reference\": 40,\n" +
                    "            \"stmtDate\": \"2022-04-24T19:00:00\",\n" +
                    "            \"label\": \"Label \",\n" +
                    "            \"debit\": 0,\n" +
                    "            \"credit\": 260.46\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"id\": 7030,\n" +
                    "            \"reference\": 36,\n" +
                    "            \"stmtDate\": \"2022-04-24T19:00:00\",\n" +
                    "            \"label\": \"Label\",\n" +
                    "            \"debit\": 100.46,\n" +
                    "            \"credit\": 0\n" +
                    "        }\n" +
                    "    ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/BankStmt/1027");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(91)
        public void SU_Get_BankStatement()
        {
            System.out.println("----------***** SU_Get_BankStatement *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BankStmt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(92)
        public void SU_Get_BankStatement_ById()
        {
            System.out.println("----------***** SU_Get_BankStatement_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/BankStmt/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //Issue in This API
        //Only This is for Post API
        @Test
        @Order(93)
        public void SU_Post_BankReconcile()
        {
            System.out.println("----------***** SU_Post_BankReconcile *****----------");


            String APIBody = "{\"BankStmtId\": 5060,\n" +
                    "        \"PaymentId\": 1181,\n" +
                    "        \"Amount\": 2115}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/BankRecon");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //Only This is for Get API
        @Test
        @Order(94)
        public void SU_Get_COA()
        {
            System.out.println("----------***** SU_Get_COA *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/COA");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(95)
        public void SU_Post_Department()
        {
            System.out.println("----------***** SU_Post_Department *****----------");


            String APIBody = "{\"name\": \"Department C\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Department");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(96)
        public void SU_Put_Department()
        {
            System.out.println("----------***** SU_Post_Department *****----------");


            String APIBody = "{\"id\": 1,\n" +
                    "   \"name\": \"Departments C\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Department/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(97)
        public void SU_Get_Department()
        {
            System.out.println("----------***** SU_Get_Department *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Department");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(98)
        public void SU_Get_Department_ById()
        {
            System.out.println("----------***** SU_Get_Department_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Department/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(99)
        public void SU_Post_Designation()
        {
            System.out.println("----------***** SU_Post_Designation *****----------");


            String APIBody = "{\"name\": \"Designation B\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Designation");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(99)
        public void SU_Put_Designation()
        {
            System.out.println("----------***** SU_Put_Designation *****----------");


            String APIBody = "{ \"id\": 1,\n" +
                    "    \"name\": \"Designation B\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Designation/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(100)
        public void SU_Get_Designation()
        {
            System.out.println("----------***** SU_Get_Designation *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Designation");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(101)
        public void SU_Get_Designation_ById()
        {
            System.out.println("----------***** SU_Get_Designation_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Designation/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(102)
        public void SU_Post_PayrollItems()
        {
            System.out.println("----------***** SU_Post_PayrollItems *****----------");


            String APIBody = "{\"itemCode\": \"Item Code\",\n" +
                    "    \"name\": \"ABC\",\n" +
                    "    \"isActive\": true,\n" +
                    "    \"payrollItemType\": 0,\n" +
                    "    \"accountId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\",\n" +
                    "    \"amount\": 550.456,\n" +
                    "    \"payrollType\": 3,\n" +
                    "    \"percentage\": 0,\n" +
                    "    \"remarks\": \"jkl\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/PayrollItem");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(103)
        public void SU_Put_PayrollItems()
        {
            System.out.println("----------***** SU_Put_PayrollItems *****----------");


            String APIBody = "{ \"id\": 1222, \n" +
                    "    \"itemCode\": \"Item Code\",\n" +
                    "    \"name\": \"ABC\",\n" +
                    "    \"isActive\": true,\n" +
                    "    \"payrollItemType\": 0,\n" +
                    "    \"accountId\": \"78a87ee1-9ee6-4b6e-c385-08d95a863b74\",\n" +
                    "    \"amount\": 550.456,\n" +
                    "    \"payrollType\": 3,\n" +
                    "    \"percentage\": 0,\n" +
                    "    \"remarks\": \"jkl\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/PayrollItem/1222");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(104)
        public void SU_Get_PayrollItems()
        {
            System.out.println("----------***** SU_Get_PayrollItems *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/PayrollItem");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(105)
        public void SU_Get_PayrollItems_ById()
        {
            System.out.println("----------***** SU_Get_PayrollItems_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/PayrollItem/1222");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(106)
        public void SU_Post_Employee()
        {
            System.out.println("----------***** SU_Post_Employee *****----------");


            String APIBody = "{\"employeeTitle\": \"MR.\",\n" +
                    "    \"name\": \"Atezaz\",\n" +
                    "    \"fatherName\": \"Khan\",\n" +
                    "    \"husbandName\": \"\",\n" +
                    "    \"surName\": \"Khan\",\n" +
                    "    \"cnic\": 4561235645898,\n" +
                    "    \"employeeType\": \"Permanent\",\n" +
                    "    \"bankId\": 2,\n" +
                    "    \"sdp\": \"df5\",\n" +
                    "    \"accountNo\": \"43656565656956\",\n" +
                    "    \"email\": \"atezaz@gmail.com\",\n" +
                    "    \"religion\": \"Islam\",\n" +
                    "    \"designationId\": 1030,\n" +
                    "    \"campusId\": 13,\n" +
                    "    \"departmentId\": 32,\n" +
                    "    \"dateOfBirth\": \"2022-04-25\",\n" +
                    "    \"dateOfRetirement\": \"2022-04-28\",\n" +
                    "    \"dateOfDeath\": \"2022-04-30\",\n" +
                    "    \"dateOfJoining\": \"2022-04-25\",\n" +
                    "    \"basicPayId\": 1184,\n" +
                    "    \"incrementId\": 1228,\n" +
                    "    \"noOFIncrements\": 1,\n" +
                    "    \"isActive\": true,\n" +
                    "    \"remarks\": \"For Integrating API in IntelliJ IDE\",\n" +
                    "    \"employeeLines\": [\n" +
                    "        {\n" +
                    "            \"payrollItemId\": 1180,\n" +
                    "            \"type\": \"Deduction\",\n" +
                    "            \"amount\": 1575,\n" +
                    "            \"percentage\": 3\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"payrollItemId\": 1186,\n" +
                    "            \"type\": \"Assignment Allowances\",\n" +
                    "            \"amount\": 5000,\n" +
                    "            \"percentage\": \"N/A\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"payrollItemId\": 1232,\n" +
                    "            \"type\": \"Deduction\",\n" +
                    "            \"amount\": 25,\n" +
                    "            \"percentage\": \"N/A\"\n" +
                    "        }\n" +
                    "    ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Employee");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(107)
        public void SU_Put_Employee()
        {
            System.out.println("----------***** SU_Put_Employee *****----------");


            String APIBody = "{\n" +
                    "    \"id\": 106,\n" +
                    "    \"employeeTitle\": \"MR.\",\n" +
                    "    \"name\": \"Atezaz\",\n" +
                    "    \"fatherName\": \"Khan\",\n" +
                    "    \"husbandName\": \"\",\n" +
                    "    \"surName\": \"Khan\",\n" +
                    "    \"cnic\": 4561235647898,\n" +
                    "    \"employeeType\": \"Permanent\",\n" +
                    "    \"bankId\": 2,\n" +
                    "    \"sdp\": \"df5\",\n" +
                    "    \"accountNo\": \"43656565656956\",\n" +
                    "    \"email\": \"atezaz@gmail.com\",\n" +
                    "    \"religion\": \"Islam\",\n" +
                    "    \"designationId\": 1030,\n" +
                    "    \"campusId\": 13,\n" +
                    "    \"departmentId\": 32,\n" +
                    "    \"dateOfBirth\": \"2022-04-25\",\n" +
                    "    \"dateOfRetirement\": \"2022-04-28\",\n" +
                    "    \"dateOfDeath\": \"2022-04-30\",\n" +
                    "    \"dateOfJoining\": \"2022-04-25\",\n" +
                    "    \"basicPayId\": 1184,\n" +
                    "    \"incrementId\": 1228,\n" +
                    "    \"noOFIncrements\": 1,\n" +
                    "    \"isActive\": true,\n" +
                    "    \"remarks\": \"For Integrating API in IntelliJ IDE\",\n" +
                    "    \"employeeLines\": [\n" +
                    "        {\n" +
                    "            \"payrollItemId\": 1180,\n" +
                    "            \"type\": \"Deduction\",\n" +
                    "            \"amount\": 1575,\n" +
                    "            \"percentage\": 3\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"payrollItemId\": 1186,\n" +
                    "            \"type\": \"Assignment Allowances\",\n" +
                    "            \"amount\": 5000,\n" +
                    "            \"percentage\": \"N/A\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"payrollItemId\": 1232,\n" +
                    "            \"type\": \"Deduction\",\n" +
                    "            \"amount\": 25,\n" +
                    "            \"percentage\": \"N/A\"\n" +
                    "        }\n" +
                    "    ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Employee/106");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(108)
        public void SU_Get_Employee()
        {
            System.out.println("----------***** SU_get_Employee *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Employee");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(109)
        public void SU_Get_Employee_ById()
        {
            System.out.println("----------***** SU_Get_Employee_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Employee/106");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(110)
        public void SU_Post_EmployeeBank()
        {
            System.out.println("----------***** SU_Post_EmployeeBank *****----------");


            String APIBody = "{\"bankName\": \"Faisal Bank\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/EmpBank");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(111)
        public void SU_Put_EmployeeBank()
        {
            System.out.println("----------***** SU_Put_EmployeeBank *****----------");


            String APIBody = "{\"id\": 8,\n" +
                    "  \"bankName\": \"Faisal Bank\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/EmpBank/8");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(112)
        public void SU_Get_EmployeeBank()
        {
            System.out.println("----------***** SU_Get_EmployeeBank *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/EmpBank");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(113)
        public void SU_Get_EmployeeBank_ById()
        {
            System.out.println("----------***** SU_Get_EmployeeBank_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/EmpBank/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(114)
        public void SU_Post_PayrollTransaction()
        {
            System.out.println("----------***** SU_Post_PayrollTransaction *****----------");


            String APIBody = "{\"transDate\": \"04/25/2022\",\n" +
                    "    \"tax\": 0,\n" +
                    "    \"designation\": \"Coordinator\",\n" +
                    "    \"department\": \"Procurment Department\",\n" +
                    "    \"basicPay\": 23000,\n" +
                    "    \"increment\": 2500,\n" +
                    "    \"employeeId\": 104,\n" +
                    "    \"month\": 1,\n" +
                    "    \"year\": 2013,\n" +
                    "    \"workingDays\": 31,\n" +
                    "    \"presentDays\": 31,\n" +
                    "    \"leaveDays\": 0,\n" +
                    "    \"accountPayableId\": \"188867f5-5434-4b2a-b91d-08d966caf67d\",\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/PayrollTransaction");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(115)
        public void SU_Put_PayrollTransaction()
        {
            System.out.println("----------***** SU_Put_PayrollTransaction *****----------");


            String APIBody = "{\"id\": 927,\n" +
                    "    \"transDate\": \"04/25/2022\",\n" +
                    "    \"tax\": 0,\n" +
                    "    \"designation\": \"Coordinator\",\n" +
                    "    \"department\": \"Procurment Department\",\n" +
                    "    \"basicPay\": 23000,\n" +
                    "    \"increment\": 2500,\n" +
                    "    \"employeeId\": 104,\n" +
                    "    \"month\": 1,\n" +
                    "    \"year\": 2013,\n" +
                    "    \"workingDays\": 31,\n" +
                    "    \"presentDays\": 31,\n" +
                    "    \"leaveDays\": 0,\n" +
                    "    \"accountPayableId\": \"188867f5-5434-4b2a-b91d-08d966caf67d\",\n" +
                    "    \"isSubmit\": 0}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/PayrollTransaction/927");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(116)
        public void SU_Get_PayrollTransaction()
        {
            System.out.println("----------***** SU_Get_PayrollTransaction *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/PayrollTransaction");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(117)
        public void SU_Get_PayrollTransaction_ById()
        {
            System.out.println("----------***** SU_Get_PayrollTransaction_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/PayrollTransaction/927");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(118)
        public void SU_Post_PayrollPayment()
        {
            System.out.println("----------***** SU_Post_PayrollPayment *****----------");


            String APIBody = "{\"PaymentRegisterType\": 1,\n" +
                    "    \"paymentType\": 1,\n" +
                    "    \"businessPartnerId\": 136,\n" +
                    "    \"accountId\": \"021731fa-1792-4b7b-db3d-08d95e2881ed\",\n" +
                    "    \"paymentDate\": \"2022-04-25\",\n" +
                    "    \"paymentRegisterId\": \"6511f8e8-9a6d-4355-ec28-08d9a4f27fb5\",\n" +
                    "    \"description\": \"fdf\",\n" +
                    "    \"grossPayment\": 850.456,\n" +
                    "    \"campusId\": 5,\n" +
                    "    \"reference\": \"569\",\n" +
                    "    \"discount\": 0,\n" +
                    "    \"salesTax\": 0,\n" +
                    "    \"incomeTax\": 10,\n" +
                    "    \"documentTransactionId\": null,\n" +
                    "    \"sst\": 0,\n" +
                    "    \"isSubmit\": 0,\n" +
                    "    \"paymentFormType\": 7}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/PayrollPayment");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(119)
        public void SU_Put_PayrollPayment()
        {
            System.out.println("----------***** SU_Put_PayrollPayment *****----------");


            String APIBody = "{\"id\": 1260,\n" +
                    "    \"PaymentRegisterType\": 1,\n" +
                    "    \"paymentType\": 1,\n" +
                    "    \"businessPartnerId\": 136,\n" +
                    "    \"accountId\": \"021731fa-1792-4b7b-db3d-08d95e2881ed\",\n" +
                    "    \"paymentDate\": \"2022-04-25\",\n" +
                    "    \"paymentRegisterId\": \"6511f8e8-9a6d-4355-ec28-08d9a4f27fb5\",\n" +
                    "    \"description\": \"fdf\",\n" +
                    "    \"grossPayment\": 850.456,\n" +
                    "    \"campusId\": 5,\n" +
                    "    \"reference\": \"569\",\n" +
                    "    \"discount\": 0,\n" +
                    "    \"salesTax\": 0,\n" +
                    "    \"incomeTax\": 10,\n" +
                    "    \"documentTransactionId\": null,\n" +
                    "    \"sst\": 0,\n" +
                    "    \"isSubmit\": 0,\n" +
                    "    \"paymentFormType\": 7}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/PayrollPayment/1260");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(120)
        public void SU_Get_PayrollPayment()
        {
            System.out.println("----------***** SU_Get_PayrollPayment *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/PayrollPayment");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(121)
        public void SU_Get_PayrollPayment_ById()
        {
            System.out.println("----------***** SU_Get_PayrollPayment_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/PayrollPayment/1260");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(122)
        public void SU_Post_Budget()
        {
            System.out.println("----------***** SU_Post_Budget *****----------");


            String APIBody = "{ \"budgetName\": \"Budget B\",\n" +
                    "    \"from\": \"2022-04-25\",\n" +
                    "    \"to\": \"2022-04-27\",\n" +
                    "    \"budgetLines\": [\n" +
                    "        {\n" +
                    "            \"accountId\": \"fdbd0486-220d-4c4e-0d5b-08d9a0217163\",\n" +
                    "            \"amount\": 8500.478\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"accountId\": \"e6137515-ed29-4232-b920-08d966caf67d\",\n" +
                    "            \"amount\": 15000.456\n" +
                    "        }\n" +
                    "    ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Budget");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(123)
        public void SU_Put_Budget()
        {
            System.out.println("----------***** SU_Put_Budget *****----------");


            String APIBody = "{ \"id\": 1,\n" +
                    "    \"budgetName\": \"Budget B\",\n" +
                    "    \"from\": \"2022-04-25\",\n" +
                    "    \"to\": \"2022-04-27\",\n" +
                    "    \"budgetLines\": [\n" +
                    "        {\n" +
                    "            \"accountId\": \"fdbd0486-220d-4c4e-0d5b-08d9a0217163\",\n" +
                    "            \"amount\": 8500.478\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"accountId\": \"e6137515-ed29-4232-b920-08d966caf67d\",\n" +
                    "            \"amount\": 15000.456\n" +
                    "        }\n" +
                    "    ]}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Budget/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(124)
        public void SU_Get_Budget()
        {
            System.out.println("----------***** SU_Get_Budget *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Budget");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(125)
        public void SU_Get_Budget_ById()
        {
            System.out.println("----------***** SU_Get_Budget_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Budget/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(126)
        public void SU_Post_Budget_BudgetReport()
        {
            System.out.println("----------***** SU_Post_Budget_BudgetReport *****----------");


            String APIBody = "{ \"budgetId\": 18,\n" +
                    "    \"to\": \"31 Aug, 2021\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/Budget/budgetReport");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(127)
        public void SU_Post_GeneralLedger()
        {
            System.out.println("----------***** SU_Post_GeneralLedger *****----------");


            String APIBody = "{\"accountName\": \"\",\n" +
                    "    \"bId\": \"\",\n" +
                    "    \"docDate\": \"2022-04-01\",\n" +
                    "    \"docDate2\": \"2022-04-25\",\n" +
                    "    \"campus\": \"\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/GeneralLedger");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(128)
        public void SU_Post_TrialBalance()
        {
            System.out.println("----------***** SU_Post_TrialBalance *****----------");


            String APIBody = "{\"docDate\": \"Apr 1, 2022\",\n" +
                    "    \"docDate2\": \"Apr 25, 2022\",\n" +
                    "    \"campus\": \"\",\n" +
                    "    \"accountName\": \"\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/TrialBalance");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(129)
        public void SU_Post_IncomeStatement()
        {
            System.out.println("----------***** SU_Post_IncomeStatement *****----------");


            String APIBody = "{ \"docDate\": \"Apr 1, 2022\",\n" +
                    "    \"docDate2\": \"Apr 25, 2022\",\n" +
                    "    \"transactional\": \"\",\n" +
                    "    \"campus\": \"\",\n" +
                    "    \"businessPartner\": \"\",\n" +
                    "    \"debit\": 0,\n" +
                    "    \"credit\": 0,\n" +
                    "    \"balance\": 0,\n" +
                    "    \"nature\": \"\",\n" +
                    "    \"summeryHead\": \"\",\n" +
                    "    \"head\": \"\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/IncomeNExpenditure");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(130)
        public void SU_Post_BalanceSheet()
        {
            System.out.println("----------***** SU_Post_BalanceSheet *****----------");


            String APIBody = "{\"docDate\": \"Apr 25, 2022\",\n" +
                    "    \"transactional\": \"\",\n" +
                    "    \"campus\": \"\",\n" +
                    "    \"businessPartner\": \"\",\n" +
                    "    \"debit\": 0,\n" +
                    "    \"credit\": 0,\n" +
                    "    \"balance\": 0,\n" +
                    "    \"nature\": \"\",\n" +
                    "    \"summeryHead\": \"\",\n" +
                    "    \"head\": \"\"}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    post("/api/BalanceSheet");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        //Made Put Request For WorkFlow (Didn't make Post Request)
        @Test
        @Order(131)
        public void SU_Put_Workflow()
        {
            System.out.println("----------***** SU_Put_Workflow *****----------");


            String APIBody = "{ \"id\": 1,\n" +
                    "    \"name\": \"Invoice\",\n" +
                    "    \"docType\": 3,\n" +
                    "    \"isActive\": true,\n" +
                    "    \"workflowTransitions\": [\n" +
                    "        {\n" +
                    "            \"currentStatusId\": 6,\n" +
                    "            \"action\": 0,\n" +
                    "            \"nextStatusId\": 8,\n" +
                    "            \"allowedRoleId\": \"dfcba2de-2e67-4841-ab4e-f0a7e7ec8958\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"currentStatusId\": 6,\n" +
                    "            \"action\": 1,\n" +
                    "            \"nextStatusId\": 2,\n" +
                    "            \"allowedRoleId\": \"dfcba2de-2e67-4841-ab4e-f0a7e7ec8958\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"currentStatusId\": 8,\n" +
                    "            \"action\": 1,\n" +
                    "            \"nextStatusId\": 2,\n" +
                    "            \"allowedRoleId\": \"dfcba2de-2e67-4841-ab4e-f0a7e7ec8958\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"currentStatusId\": 8,\n" +
                    "            \"action\": 0,\n" +
                    "            \"nextStatusId\": 9,\n" +
                    "            \"allowedRoleId\": \"dfcba2de-2e67-4841-ab4e-f0a7e7ec8958\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"createdDate\": \"2021-08-08T16:40:14.5857483\",\n" +
                    "    \"modifiedDate\": \"2021-08-08T16:40:14.5857483\",\n" +
                    "    \"createdBy\": \"Hamza\",\n" +
                    "    \"modifiedBy\": \"Hamza\",\n" +
                    "    \"isDelete\": false}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Workflow/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(132)
        public void SU_Get_Workflow()
        {
            System.out.println("----------***** SU_Get_Workflow *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Workflow");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(133)
        public void SU_Get_Workflow_ById()
        {
            System.out.println("----------***** SU_Get_Workflow_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Workflow/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //Made Put Request For Status (Didn't make Post Request)
        @Test
        @Order(134)
        public void SU_Put_Status()
        {
            System.out.println("----------***** SU_Put_Status *****----------");


            String APIBody = "{ \"id\": 9,\n" +
                    "    \"status\": \"Approved by Director Finance\",\n" +
                    "    \"state\": 2,\n" +
                    "    \"type\": 0,\n" +
                    "    \"createdDate\": \"2021-08-08T16:16:08.9525682\",\n" +
                    "    \"modifiedDate\": \"2021-08-16T12:00:52.4315259\",\n" +
                    "    \"createdBy\": \"Hamza\",\n" +
                    "    \"modifiedBy\": \"Hamzazahid\",\n" +
                    "    \"isDelete\": false}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/Status/9");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(135)
        public void SU_Get_Status()
        {
            System.out.println("----------***** SU_Get_Status *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Status");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(136)
        public void SU_Get_Status_ById()
        {
            System.out.println("----------***** SU_Get_Status_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/Status/9");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //Issue in Post API
        @Test
        @Order(137)
        public void SU_Put_ChallanStatement()
        {
            System.out.println("----------***** SU_Put_ChallanStatement *****----------");


            String APIBody = "{ \"id\": 14,\n" +
                    "    \"bankAccountId\": 15,\n" +
                    "    \"bankAccount\": {\n" +
                    "        \"id\": 15,\n" +
                    "        \"docNo\": \"BNK-015\",\n" +
                    "        \"department\": \"Thatta\",\n" +
                    "        \"accountNumber\": 123,\n" +
                    "        \"accountTitle\": \"Thatta University\",\n" +
                    "        \"accountType\": 0,\n" +
                    "        \"bankName\": \"Al Habib\",\n" +
                    "        \"branch\": \"Thatta\",\n" +
                    "        \"ibnNumber\": \"\",\n" +
                    "        \"openingBalance\": 5650.56,\n" +
                    "        \"currency\": \"PKR\",\n" +
                    "        \"campusId\": 12,\n" +
                    "        \"campus\": null,\n" +
                    "        \"chAccountId\": \"3cfd599a-de4f-42d5-070a-08d9a4e5ae65\",\n" +
                    "        \"chAccount\": null,\n" +
                    "        \"clearingAccountId\": \"32deba9b-11cb-4ec6-070b-08d9a4e5ae65\",\n" +
                    "        \"clearingAccount\": null,\n" +
                    "        \"transactionId\": 1318,\n" +
                    "        \"transactions\": null,\n" +
                    "        \"createdDate\": \"2021-11-11T07:34:23.4216382\",\n" +
                    "        \"modifiedDate\": \"2021-11-11T07:34:23.5767407\",\n" +
                    "        \"createdBy\": \"Alex\",\n" +
                    "        \"modifiedBy\": \"Alex\",\n" +
                    "        \"isDelete\": false\n" +
                    "    },\n" +
                    "    \"description\": \"abc\",\n" +
                    "    \"challanStmtLines\": [\n" +
                    "        {\n" +
                    "            \"id\": 38,\n" +
                    "            \"reference\": \"56\",\n" +
                    "            \"stmtDate\": \"2022-04-24T19:00:00\",\n" +
                    "            \"label\": \"Label\",\n" +
                    "            \"debit\": 650.25,\n" +
                    "            \"credit\": 0\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"id\": 39,\n" +
                    "            \"reference\": \"23\",\n" +
                    "            \"stmtDate\": \"2022-04-24T19:00:00\",\n" +
                    "            \"label\": \"Label\",\n" +
                    "            \"debit\": 0,\n" +
                    "            \"credit\": 750.56\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"createdDate\": \"2022-04-25T09:50:31.0534536\",\n" +
                    "    \"modifiedDate\": \"2022-04-25T09:50:31.0534536\",\n" +
                    "    \"createdBy\": \"Alex\",\n" +
                    "    \"modifiedBy\": \"Alex\",\n" +
                    "    \"isDelete\": false}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/ChallanStmt/14");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(138)
        public void SU_Get_ChallanStatement()
        {
            System.out.println("----------***** SU_Get_ChallanStatement *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/ChallanStmt");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(139)
        public void SU_Get_ChallanStatement_ById()
        {
            System.out.println("----------***** SU_Get_ChallanStatement_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/ChallanStmt/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }

        //There is no Post API for this Entity
        @Test
        @Order(140)
        public void SU_Put_FeeType()
        {
            System.out.println("----------***** SU_Put_FeeType *****----------");


            String APIBody = "{\"id\": 34,\n" +
                    "    \"accountId\": \"23d8251d-140f-4165-4656-08d9609ed474\",\n" +
                    "    \"account\": null,\n" +
                    "    \"receivableAccountId\": \"b4be1863-2021-48bd-4654-08d9609ed474\",\n" +
                    "    \"receivableAccount\": null}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    put("/api/FeeType/34");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(141)
        public void SU_Get_FeeType()
        {
            System.out.println("----------***** SU_Get_FeeType *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/FeeType");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }


        @Test
        @Order(142)
        public void SU_Get_FeeType_ById()
        {
            System.out.println("----------***** SU_Get_FeeType_ById *****----------");


            String APIBody = "{}";


            List<Header> headerlist = new ArrayList<Header>();
            //headerlist.add(new Header("Content-Type","application/json"));
            headerlist.add(new Header(headerType, headerMediaType));
//            headerlist.add(new Header("device-id","1"));
//            headerlist.add(new Header("user-agents","postman"));
//            headerlist.add(new Header("device-type","web")); //check this
//            headerlist.add(new Header("license-key","213DD508-876F-4DD3-BBC1-0A33CC54A6C0")); //check this
//            headerlist.add(new Header("user-host-name","hakim"));
//            headerlist.add(new Header("user-language","English"));
//            headerlist.add(new Header("user-host-address","::::0"));
            //headerlist.add(new Header("AuthToken","bearer eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBZG1pbiIsIlVzZXJJZCI6IjI2IiwiVXNlclR5cGUiOiJBZG1pbiIsImV4cCI6MTc0OTAzNzk0MCwiaXNzIjoic21lc2suaW4iLCJhdWQiOiJyZWFkZXJzIn0.X7a2_Hf9m5aW8ufa02qJhTlbb-Cg3fX1ljkk5szN6pw "));
            //headerlist.add(new Header("Authorization","bearer "+token));
            headerlist.add(new Header(name,value));
            Headers headers = new Headers(headerlist);



            Response r = given().body(APIBody).
                    headers(headers).
                    when().
                    get("/api/FeeType/1");

            //r.prettyPrint();
            String body = r.getBody().asString();
            //ResponseBody  body = r.getBody();
            System.out.println(body);

            int statusCode = r.getStatusCode();
            System.out.println(statusCode);

            //Assert that correct status code is returned.
            //assertEquals(statusCode /*actual value*/, 200 /*expected value*/);


//            String bodyAsString = body.asString();
//            System.out.println(bodyAsString);

//            if(!bodyAsString.contains("Data Fetched Successfully from Database") || !bodyAsString.contains("true"))
//            {
//                System.out.println("(API responded wrong)");
//                fail();
//            }
        }
    }
}
