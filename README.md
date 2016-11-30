# RESTful Web Services (Jax-RS 2.0)
[RESTful](https://hu.wikipedia.org/wiki/REST)

##  JAX-RS (Jersey)

###  Maven (Jersey 1.x)
    <properties>
        <version.jersey>1.19.3</version.jersey>
    <properties>
    
        <dependency>
            <groupId>asm</groupId>
            <artifactId>asm</artifactId>
            <version>3.3.1</version>
        </dependency>
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20160810</version>
        </dependency>
        <dependency>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-bundle</artifactId>
            <version>${version.jersey}</version>
        </dependency>
        <dependency>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-server</artifactId>
            <version>${version.jersey}</version>
        </dependency>
        <dependency>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-core</artifactId>
            <version>${version.jersey}</version>
        </dependency>

### Maven (Jersey 2.x)

    <properties>
        <version.jersey>2.15</version.jersey>
    <properties>
    
    <dependency>
        <groupId>org.glassfish.jersey.containers</groupId>
        <artifactId>jersey-container-servlet</artifactId>
        <version>${version.jersey}</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jersey.media</groupId>
        <artifactId>jersey-media-json-jackson</artifactId>
        <version>${version.jersey}</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jersey.media</groupId>
        <artifactId>jersey-media-json-processing</artifactId>
        <version>${version.jersey}</version>
    </dependency>
    
### Education material
[Technology specification (JSR 339)](https://jcp.org/en/jsr/detail?id=339)

[Oracle Java EE 7 tutorial](https://docs.oracle.com/javaee/7/tutorial/partwebsvcs.htm#BNAYK)

### API and applications
#### @Path [Javadoc](https://docs.oracle.com/javaee/7/api/javax/ws/rs/Path.html), [Example](frontend-jquery-bootstrap/src/main/java/hu/ulyssys/rest/SportTypeService.java)
    Elérési út

#### @GET [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/GET.html), [Example](frontend-jquery-bootstrap/src/main/java/hu/ulyssys/rest/SportTypeService.java)
    Válasz egy HTTP GET kérésre 

#### @POST [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/POST.html)
    Válasz egy HTTP POST kérésre 

#### @PUT [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/GET.html)
    Válasz egy HTTP PUT kérésre 

#### @DELETE [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/DELETE.html)
    Válasz egy HTTP DELETE kérésre 

#### @HEAD [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/HEAD.html)
    Válasz egy HTTP HEAD kérésre 

#### @PathParam [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/PathParam.html) 
    URL path paraméter elérés

#### @QueryParam [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/QueryParam.html)


#### @Consumes [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/Consumes.html)


#### @Produces [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/Produces.html)
    Output típus meghatározása

#### @Provider [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/Provider.html)


#### @ApplicationPath [Java API](https://docs.oracle.com/javaee/7/api/javax/ws/rs/ApplicationPath.html)
    Alkalmazás URL

#### @Context[Java API]()



### Projekt files

## JavaScript
[Bevezető](https://hu.wikipedia.org/wiki/JavaScript)

### Education material
[MDN](https://developer.mozilla.org/hu/docs/Web/JavaScript)
[DOM](https://developer.mozilla.org/hu/docs/Web/API/Document_Object_Model/Introduction)
[JSON](https://developer.mozilla.org/hu/docs/Web/JavaScript/Reference/Global_Objects/JSON)
[Ajax](https://developer.mozilla.org/en-US/docs/AJAX)
[XMLHTTPRequest](https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/Using_XMLHttpRequest)

### Mintaprojekt elemek

## jQuery

### Mintaprojekt elemek

## Angular2

### Mintaprojekt elemek

## React

### Mintaprojekt elemek

## SPA (Single Page Applications)
