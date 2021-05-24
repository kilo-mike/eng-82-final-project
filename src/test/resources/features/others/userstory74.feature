Feature:
  Scenario: users access data stored from previous sessions

  Given that data has been previously stored in the database

  When that data is accessed from by the system

  Then the data should be retrieved in its entirety with nothing lost