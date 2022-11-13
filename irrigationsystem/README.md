# Irrigation System

## About
A SpringBoot application that automates the irrigation of land plots.
The Application works as the following: 
* Admin adds land plot with the time slot of when its first irrigation will start
* With every call to irrigate, the land plot's time slot will be updated to its next irrigation time slot
* The time slot is updated with respect to the first time slot, not current time


## Technical Stack
- Java 17
- Spring Boot
- Junit 5

## Endpoints
* `GET /api/land_plot/` Gets a list of land plots
* `GET /api/land_plot/{id}` Gets the land plot with the sent id
* `POST /api/land_plot` Creates land plot
* `PUT /api/land_plot` Updates land plot
* `DELETE /api/land_plot/{id}` Deletes land plot
* `PUT /api/land_plot/irrigate/{id}` Irrigates land plot and updates the land plot's time slot

## Testing
- Integration Tests are implemented using Jupiter(Junit 5) library

## Note

  * To be done: switching the irrigation process from a manual REST call to an automated scheduled 
REST call using @Scheduler

