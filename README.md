# Enterprise Data Architecture(EDA) Design - Course Project
## Insurance Database Systems 
### Description
Many businesses have the goal to establish an Enterprise Data Architecture(EDA) and to promote subsequent activities related to the integration of existing and new projects with the EDA. 


There are total three files implemented by me based on the support material for the project(**EDA Project Support Materia.pdf**) to get the customer's inquiries regarding insurance products.

1. ConceptualDataModel.pdf
    * Modeling - creation of a diagram and/or blueprint the supports the design of enterprise storage systems.
2. LogicalDataModel.pdf
    * Operational Data Store(ODS) - Creation of physical database that conform to the model
3. JDBCCode.java
    * execute applications/operations to integrate with the ODS.
 
* Note: 
For the better access to the materials, those ConceptualDataModel / LogicalDataModel files are converted into pdf files after designed by PowerDesigner/MySQL tools. 

## Tools/Skills to implement the files
1. PowerDesigner 
2. MySQL
3. JDBC
4. J2EE


## Query Execution
The **JDBCCode.java** file will be executed to get the customer's insurance inquiries.
When you compile the file, you can go to the static method **getQuote()**. 
You can try various SQL statements to see the result as followings; 




1. Print all the information from invoice table where the due date is august 10th. 
					
SELECT *
FROM INVOICE
WHERE DUE_DATE = Aug.10th 


2. Print customer ssn and billing code from invoice table where billing code is b234 and the paid date is Aug. 28th.
					
SELECT CUSTOMER_CUSTOMER_SSN, BILLING_ACCOUNT_BILLING_CODE
FROM INVOICE
WHERE BILLING_ACCOUNT_BILLING_CODE = B234 AND PAID_DATE = ‘AUG 28’ 


3. Print all customer’s name, invoice number, product name and the description where th customer’s zip code is 07301 
			
SELECT C.FIRST_NAME, C.LAST_NAME, I.INVOICE_NUMBER, P.PRODUCT_NAME, P.DESCRIPTION
FROM C.CUSTOMER, I.INVOICE, P.PRODUCT.NAME
WHERE C.CUSTOMER_ZIP = 07301



