# rest-assured-fw
# Command to run the test
$ mvn test -Dcucumber.filter.tags="@DeletePlace"

# Command to run the test with cucumber report html
$ mvn test verify -Dcucumber.filter.tags="@AddPlace or @DeletePlace"