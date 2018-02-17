set projectLocation=C:\Users\hp\workspace2\Demo
cd %projectLocation%
set classpath=C:\Users\hp\workspace2\Demo\target\test-classes\;C:\Users\hp\workspace2\Demo\target\classes\;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml

pause