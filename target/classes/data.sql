INSERT INTO role (id, name) VALUES
  (1,'user'),
  (2,'admin');



INSERT INTO user (id, username, password, role_id) VALUES
  (1,'kruno@email.com','$2y$12$tUco7nEy4Q1uaCOCgyxM6elc23KC8WmuFSxdwDmr4943RZt9dzukq',1),
  (2,'vjeko@email.com','$2y$12$tUco7nEy4Q1uaCOCgyxM6elc23KC8WmuFSxdwDmr4943RZt9dzukq',2);

  INSERT INTO organization (id, name) VALUES
    (1,'ghd'),
    (2,'res med');


  INSERT INTO project (id,name ,organization_id) VALUES
    (1,'mulesoft',1),
    (2,'support',2),
    (3,'supportaaaaa',2);


INSERT INTO user_project (user_id, project_id) VALUES
  (1,1),
  (1,2),
  (2,1);


INSERT INTO timesheet (id, end_date , description, user_id, project_id, start_date) VALUES
  (1,'2008-10-29 14:56:59','1',1,1,'2008-10-29 13:56:59'),
  (2,'2008-10-29 14:56:59','2',1,2,'2008-10-29 13:56:59'),
  (5,'2008-10-29 14:56:59','5',1,1,'2008-10-29 13:56:59'),
  (3,'2010-10-29 15:56:59','3',1,1,'2010-10-29 12:56:59'),
  (4,'2008-10-29 15:56:59','aaaaa',2,1,'2008-10-29 12:56:59');
