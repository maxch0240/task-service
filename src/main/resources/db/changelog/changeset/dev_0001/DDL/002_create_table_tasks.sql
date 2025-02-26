CREATE TABLE tasks (
    task_id        BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    performer_id    INT             NOT NULL  REFERENCES users (user_id),
    name            VARCHAR(256)    NOT NULL,
    start_time      TIMESTAMP       NOT NULL,
    deadline_time   TIMESTAMP       NOT NULL,
    status          VARCHAR(256)    NOT NULL,
    task_type       VARCHAR(256)    NOT NULL
);