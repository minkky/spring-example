CREATE TABLE member (
    user_id VARCHAR(50) NOT NULL,
    user_pw VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    regdate TIMESTAMP DEFAULT now(),
    updatedate TIMESTAMP DEFAULT now(),
    PRIMARY KEY (user_id)
)