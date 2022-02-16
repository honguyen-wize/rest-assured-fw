# rest-assured-fw
# Command to run the test
$ mvn test -Dcucumber.filter.tags="@AddPlace or @DeletePlace" -Denv="staging"

# Command to run the test with cucumber report html locally (target/cucumber-html-reports)
$ mvn verify -Dcucumber.filter.tags="@AddPlace or @DeletePlace" -Denv="staging"
