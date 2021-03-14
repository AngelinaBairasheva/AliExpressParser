# AliExpressParser
About
Web application parses first hundred products from online store at 1 minute and saves featured information into the CSV file. 
App downloads products information from original site and saves them to the file. 

Application was created using libs:

net.sf.opencsv

org.json

java.net

Algorithm for solving:

You can get the products at: https://gpsfront.aliexpress.com/getRecommendingResults.do 
In the parameters you can set a limit of up to 50 products, but you can't get more than 40. 
We will need to make 3 requests: 20 products and 2 requests for 40 products. 
Why do 3 - we need the postback parameter for requests in the loop, without it, there will be an error further than 50 products. 
The parameter itself will come along with 1 request
