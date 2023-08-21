# Welcome to my project in development.

This project is currently in development. 

## Issue:
My company (referred to as Company below) is an educational services company that provide tutoring sessions to students, and many tutoring sessions are outsources to independent contractors. There is a large number of contractors, and Company needs a more efficient system to keep track of instructor information and tutoring subjects to streamline the scheduling process. 

## User story:
User types: Student Manager, Admin

### Instructors Page
All authenticated users can view list of instructors. Users can order the list by clicking on row head.\
If user clicks instructor name, automatically routed to instructor detail page.\
If user clicks subject, automatically routed to subject page. 

### Instructor Detail Page
All authenticated users can view instructor info and provide rating for instructor. 

### Subject Page
All authenticated users can see all available instructors of a given subject. 

### Admin Page
Admin can add, update, and delete instructor. \
Admin can create new student manager or admin accounts. \
??not sure: Admin can create new subject? 

## Project Development Plan:
- [x] generate diagram for API
- [x] write SQL database (wrote test data; no user authentication function at this time)
- [ ] write REST API with Spring Boot
- [ ] write front end
- [ ] project online 

## Developer Progress Notes:
<ul>
<li>
8/5/2023: Wrote SQL Script
</li>
<li>
8/6/2023: Created Spring Boot application. \
Next Step: Plan Controllers. Write in comment.
</li>
<li>
8/8/2023: Generally planned controllers. \
Next Step: Rethink controllers. Write Spring Boot.
</li>
<li>
8/9/2023: Worked on Instructors Controller. Wrote Instructor Model. Finished Instructor DAO Interface. Finished Instructor DAO getAll and Find. Tested. \ 
Next Step: Finish other methods in Instructor DAO. Test. Repeat for other models.
</li>
<li>
8/10/2023: Finished Instructor DAO and tested.
</li>
<li>
8/17/2023: Back from Break. Working on Subjects. \ 
Next Step: Work on JdbcSubjectDao and Tests 
</li>
<li>
8/21/2023: Finished Subjects. \ 
Next Step: Work on Subject-Instructor Objects
</li>
</ul>
