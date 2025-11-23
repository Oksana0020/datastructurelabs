COPY (SELECT * FROM movies)        TO 'C:/exports/movies.csv'        WITH CSV HEADER;
COPY (SELECT * FROM actors)        TO 'C:/exports/actors.csv'        WITH CSV HEADER;
COPY (SELECT * FROM genres)        TO 'C:/exports/genres.csv'        WITH CSV HEADER;
COPY (SELECT * FROM movies_actors) TO 'C:/exports/movies_actors.csv' WITH CSV HEADER;
















