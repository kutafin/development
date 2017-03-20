
CREATE TABLE url_tags (
  urlId INT NOT NULL,
  tagId INT NOT NULL,

  FOREIGN KEY (urlId) REFERENCES shorturl (idUrl),
  FOREIGN KEY (tagId) REFERENCES tags (idTag),

  UNIQUE (urlId, tagId)
)
  ENGINE = InnoDB;



