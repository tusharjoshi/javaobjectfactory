# Java Object Factory - example usage

This project describes typical usage of the ObjectFactory class
and the code for mocking the factory using mocking helper.

## Project dependencies

```xml
<dependencies>

  <dependency>
    [...]
    <groupId>com.tusharjoshi.javatools</groupId>
    <artifactId>objectfactory</artifactId>
    <version>${objectfactory.version}</version>
  </dependency>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>${junit.version}</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-all</artifactId>
    <version>${mockito.version}</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.powermock</groupId>
    <artifactId>powermock-module-junit4</artifactId>
    <version>${powermock.version}</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.powermock</groupId>
    <artifactId>powermock-api-mockito</artifactId>
    <version>${powermock.version}</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.powermock</groupId>
    <artifactId>powermock-core</artifactId>
    <version>${powermock.version}</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>com.tusharjoshi.javatools</groupId>
    <artifactId>objectfactory-mockito</artifactId>
    <version>${objectfactory.version}</version>
    <scope>test</scope>
  </dependency>
  [...]
</dependencies>
```

`objectfactory` project is used as a development dependency and `objectfactory-mockito` is used as a test dependency to use the mocking 
helper class in test cases.

```java
@RunWith(PowerMockRunner.class)
@PrepareForTest({ ObjectFactory.class })
public class PersonServiceTest {

	private PersonService target;
	private Person mockPerson;

	@Before
	public void setUp() {
		mockPerson = Mockito.mock(Person.class);

		ObjectFactoryMocker.mock().when(Person.class, mockPerson);

		target = new PersonService();
	}

	@Test
	public void testEnrollPerson() {

		Person person = target.enrollPerson();
		
		Assert.assertEquals(mockPerson, person);
	}
}
```