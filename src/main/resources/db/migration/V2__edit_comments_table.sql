ALTER TABLE comments DROP CONSTRAINT fk_comment_posts;
ALTER TABLE comments
    ADD CONSTRAINT fk_comment_posts
    FOREIGN KEY (post_id)
    REFERENCES posts (id)
    ON UPDATE NO ACTION
    ON DELETE CASCADE;
