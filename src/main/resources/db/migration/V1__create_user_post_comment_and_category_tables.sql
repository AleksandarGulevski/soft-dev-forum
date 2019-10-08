CREATE TABLE users (
id bigserial not null,
first_name character varying(100) NOT NULL,
last_name character varying(100) NOT NULL,
user_name character varying(100) NOT NULL,
email character varying(100) NOT NULL,
CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE categories (
id bigserial not null,
name character varying(100) NOT NULL,
CONSTRAINT category_pkey PRIMARY KEY (id)
);

CREATE TABLE posts (
id bigserial not null,
title character varying(100) NOT NULL,
content character varying(30000) NOT NULL,
created_at TIMESTAMP WITH TIME ZONE not null,
user_id bigint not null,
category_id bigint not null,
CONSTRAINT post_pkey PRIMARY KEY (id),
CONSTRAINT fk_post_users
FOREIGN KEY (user_id)
REFERENCES users (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION,
CONSTRAINT fk_post_categories
FOREIGN KEY (category_id)
REFERENCES categories (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
);

CREATE TABLE comments (
id bigserial not null,
content character varying(4000),
created_at TIMESTAMP WITH TIME ZONE not null,
post_id bigint not null,
CONSTRAINT comment_pkey PRIMARY KEY (id),
CONSTRAINT fk_comment_posts
FOREIGN KEY (post_id)
REFERENCES posts (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
);