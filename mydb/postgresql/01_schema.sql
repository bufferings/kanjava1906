CREATE TABLE IF NOT EXISTS speakers (
  id SERIAL,
  name VARCHAR(30),
  screen_name VARCHAR(30),
  CONSTRAINT pk_speakers PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS idx_speakers_name ON speakers (name);

ALTER SEQUENCE speakers_id_seq RESTART WITH 100;
