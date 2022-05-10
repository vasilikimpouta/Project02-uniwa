# Project
 Εργασία java 
 
Το πρόγραμμα έχει δομηθεί σε τρία επίπεδα:

1) Controller
2) Service 
3) Repository 



## Controller 
To επίδεδο controller είναι υπεύθυνο
για την επικοινωνία με τον  χρήστη . Στο class `ChoiceController` είναι υπευθυνό να 
λάβει την επιλογή του χρήστη για το μενού και μεταβιβάζεται στην main 
οπού υπάρχει η βασική αρίθμηση του μενού 
πλοήγησης για έλεγχο και αντιστοίχιση . 
Στο class `StudentController` παρέχονται μεθόδοι προκειμένου ο χρήστης της εφαρμογής 
 να μπορεί να διαχειριστεί το student resource.  


## Service: 
To `StudentService` αυτό είναι υπεύθυνο για την επικοινωνία του `StudentController` 
και του `StudentRepository`. 



## Repository : 
Το `StudentRepository` είναι ένα αποθετήριο δεδομένων για τους μαθητές.
και παρέχει  μεθόδους για να διαβάζουμε και να τροποποίουμε την συλλογή από μαθητές.   


## Main :

Είναι υπεύθυνη για την λειτουργεία (τρέξιμο) του προγράμματος και περιέχει το 
βασικό μενού της εφαρμογής . 