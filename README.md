# Selenium Java with Maven test projects
- Selenium official website [click here][selenium]
- Maven official website [click here][maven]
## Testing

### Test framework for next 3 pages
1. OrangeHRM
Official website [Click here][orange]

2. ToolsQA
Official website [Click here][toolsQa]

3. WebShop
Official website [Click here][webShop]

&nbsp;   
### Test run with local environment

- Open terminal in project root
- Run `mvn test` command

&nbsp;
### Test run with remote environment

* Open terminal in project root
* Run `mvn test -DremoteIp=http://<ip-address>:<port>/wd/hub`
    * example `mvn test -DremoteIp=http://localhost:4444/wd/hub`

&nbsp;
### Remote environment scripts

* Scripts are in `./scripts/selenium-grid` later referenced as `SCRIPTS_HOME_DIR`
  
&nbsp;
#### Start HUB - start hub with script command

* Open terminal in `SCRIPTS_HOME_DIR`
* Run `./start_hub.sh <options>`
    * options:
      
      Option prefix   | Option desc  | Example | Default value
      | :---:         | :---:        | :---:   | :---:
      -p              | Startup port | -p 8080 | 4444
      -f              | Executable `.jar` file | -f <path-to-file>/server.jar | search `.jar` file in the same dir


&nbsp;
#### Start NODE - connect to hub

* Open terminal in `SCRIPTS_HOME_DIR`
* Run `./start_node.sh <options>`
    * options:

      Option prefix     | Option desc                       | Example                                      | Default value
      | :---:           | :---:                             | :---:                                        | :---:
      -f                | Executable `.jar` file            | -f <path-to-file>/server.jar                 | search `.jar` file in the same dir
      --chromedriver    | path to Chrome web driver         | -p 8080                                      | search file based on `chrome*.*` in the same dir
      --edgedriver      | path to Edge(chromium) web driver | -f ./selenium-server-standalone-3.141.59     | search file based on `*edge*.*` in the same dir
      --geckodriver     | path to Firefox web driver        | --geckodriver <path-to-file>/geckodriver.exe | search file based on `gecko*.*` in the same dir
      --remoteip        | Ip of Hub                         | --remoteip http://127.0.0.1:4444             | http://127.0.0.1:4444



[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)
[selenium]: <https://www.selenium.dev//>
[maven]: <https://maven.apache.org/>
[orange]: <https://orangehrm-demo-6x.orangehrmlive.com/>
[toolsQa]: <https://demoqa.com/>
[webShop]: <http://automationpractice.com/>
[allure]: <http://allure.qatools.ru/>
