CREATE TABLE teams (
  id BIGINT AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  PRIMARY KEY(id)
) /*! ENGINE=INNODB */;

CREATE TABLE members (
  id BIGINT AUTO_INCREMENT,
  team_id BIGINT NOT NULL,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(team_id)
    REFERENCES teams(id) ON DELETE CASCADE
) /*! ENGINE=INNODB */;
