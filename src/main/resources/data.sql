INSERT INTO tb_plan(price,name) values (15,'2 Telas');
INSERT INTO tb_plan(price,name) values (30,'4 Telas');

INSERT INTO tb_user (username, email, password,plan_id) VALUES ('Alex' , 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG',2);
INSERT INTO tb_user (username, email, password,plan_id) VALUES ('Maria', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG',1);

INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);

INSERT INTO tb_genre(name) values ('Ação');
INSERT INTO tb_genre(name) values ('Aventura');
INSERT INTO tb_genre(name) values ('Animação');
INSERT INTO tb_genre(name) values ('Kids');
INSERT INTO tb_genre(name) values ('Terror');

INSERT INTO tb_trailer(title,video_uri) values ('Trailer:O reino proibido','https://www.youtube.com/watch?v=2064Ctjv1jo');
INSERT INTO tb_trailer(title,video_uri) values ('Trailer:Karate kid','https://www.youtube.com/watch?v=2064Ctjv1jo');
INSERT INTO tb_trailer(title,video_uri) values ('Trailer:Escola de super-herois','https://www.youtube.com/watch?v=2064Ctjv1jo');
INSERT INTO tb_trailer(title,video_uri) values ('Trailer:Batman','https://www.youtube.com/watch?v=2064Ctjv1jo');
INSERT INTO tb_trailer(title,video_uri) values ('Trailer:Flash','https://www.youtube.com/watch?v=2064Ctjv1jo');
INSERT INTO tb_trailer(title,video_uri) values ('Trailer:Superman','https://www.youtube.com/watch?v=2064Ctjv1jo');
INSERT INTO tb_trailer(title,video_uri) values ('Trailer:Brincando com fogo','https://www.youtube.com/watch?v=2064Ctjv1jo');
INSERT INTO tb_trailer(title,video_uri) values ('Trailer:Control Z','https://www.youtube.com/watch?v=2064Ctjv1jo');
INSERT INTO tb_trailer(title,video_uri) values ('Trailer:Titãs','https://www.youtube.com/watch?v=2064Ctjv1jo');

INSERT INTO tb_topic(title) values ('Assistir novamente');
INSERT INTO tb_topic(title) values ('Em alta');
INSERT INTO tb_topic(title) values ('Filmes românticos');
INSERT INTO tb_topic(title) values ('Series para maratonar');
INSERT INTO tb_topic(title) values ('Só na netflix');
INSERT INTO tb_topic(title) values ('Brasil:top 10 em filmes hoje');
INSERT INTO tb_topic(title) values ('Séries de terror e ficção científica');
INSERT INTO tb_topic(title) values ('Filmes brasileiros');
INSERT INTO tb_topic(title) values ('Lançamentos');

INSERT INTO tb_section(name) values ('Seção de Perfil');
INSERT INTO tb_section(name) values ('Seção de Principal');

INSERT INTO tb_movie_list(title) values ('Minha Lista');
INSERT INTO tb_movie_list(title) values ('Minha Lista');
INSERT INTO tb_movie_list(title) values ('Minha Lista');
INSERT INTO tb_movie_list(title) values ('Minha Lista');
INSERT INTO tb_movie_list(title) values ('Minha Lista');
INSERT INTO tb_movie_list(title) values ('Minha Lista');

INSERT INTO tb_profile(name,user_id,movie_list_id) values ('Luiz',1,1);
INSERT INTO tb_profile(name,user_id,movie_list_id) values ('Bob',1,2);
INSERT INTO tb_profile(name,user_id,movie_list_id) values ('Maria',1,3);
INSERT INTO tb_profile(name,user_id,movie_list_id) values ('jeredy',1,4);

INSERT INTO tb_profile(name,user_id,movie_list_id) values ('José',2,5);
INSERT INTO tb_profile(name,user_id,movie_list_id) values ('João',2,6);

INSERT INTO tb_notification(img_uri,message,moment,profile_id) values ('https://infonet.com.br/wp-infonet/img/Cinema/grande-reino-proibido.jpg','Filme lançará em breve',TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z',1);
INSERT INTO tb_notification(img_uri,message,moment,profile_id) values ('https://infonet.com.br/wp-infonet/img/Cinema/grande-reino-proibido.jpg','Filme lançará em breve',TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z',2);
INSERT INTO tb_notification(img_uri,message,moment,profile_id) values ('https://infonet.com.br/wp-infonet/img/Cinema/grande-reino-proibido.jpg','Filme lançará em breve',TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z',3);
INSERT INTO tb_notification(img_uri,message,moment,profile_id) values ('https://infonet.com.br/wp-infonet/img/Cinema/grande-reino-proibido.jpg','Filme lançará em breve',TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z',4);
INSERT INTO tb_notification(img_uri,message,moment,profile_id) values ('https://infonet.com.br/wp-infonet/img/Cinema/grande-reino-proibido.jpg','Filme lançará em breve',TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z',5);
INSERT INTO tb_notification(img_uri,message,moment,profile_id) values ('https://infonet.com.br/wp-infonet/img/Cinema/grande-reino-proibido.jpg','Filme lançará em breve',TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z',6);

INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('O reino proibido','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://infonet.com.br/wp-infonet/img/Cinema/grande-reino-proibido.jpg','12 anos','https://www.youtube.com/watch?v=2064Ctjv1jo',1,30,1,1);
INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('Karate kid','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://upload.wikimedia.org/wikipedia/pt/0/00/The_Karate_Kid_2010.jpg','12 anos','https://www.youtube.com/watch?v=2064Ctjv1jo',1,20,2,1);
INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('Escola de super-herois','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://disneyplusbrasil.com.br/wp-content/uploads/2020/08/Sky-High-Super-Escola-de-Her%C3%B3is-1024x576.jpg','Livre','https://www.youtube.com/watch?v=2064Ctjv1jo',1,24,3,1);
INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('Batman','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://s03.video.glbimg.com/x720/9955266.jpg','14 anos','https://www.youtube.com/watch?v=2064Ctjv1jo',2,10,4,2);
INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('Flash','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://rollingstone.uol.com.br/media/uploads/ator_grant_gustin_em_the_flash_foto_reproducao_twitter_the_flash.png','Livre','https://www.youtube.com/watch?v=2064Ctjv1jo',null,50,5,3);
INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('Superman','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://observatoriodocinema.uol.com.br/wp-content/uploads/2022/04/dc-superman.jpg','12 anos','https://www.youtube.com/watch?v=2064Ctjv1jo',1,30,6,4);
INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('Brincando com fogo','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://br.web.img2.acsta.net/pictures/21/07/06/16/19/4104526.jpg','16 anos','https://www.youtube.com/watch?v=2064Ctjv1jo',null,45,7,1);
INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('Control Z','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://streamingsbrasil.com/wp-content/uploads/2022/05/control-z-3-temporada-netflix.jpg','14 anos','https://www.youtube.com/watch?v=2064Ctjv1jo',null,50,8,2);
INSERT INTO tb_movie(title,synopse,img_uri,classification,video_uri,hour,min,trailer_id,movie_list_id) values ('Titãs','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.','https://rollingstone.uol.com.br/media/_versions/titas-poster-3temporada-reproducao-divulgacao-hbomax_widelg.jpg','12 anos','https://www.youtube.com/watch?v=2064Ctjv1jo',null,40,9,2);

INSERT INTO tb_like_movie (user_id, movie_id) VALUES (1, 1);
INSERT INTO tb_like_movie (user_id, movie_id) VALUES (1, 2);
INSERT INTO tb_like_movie (user_id, movie_id) VALUES (1, 8);
INSERT INTO tb_like_movie (user_id, movie_id) VALUES (2, 8);
INSERT INTO tb_like_movie (user_id, movie_id) VALUES (2, 4);

INSERT INTO tb_deslike_movie (user_id, movie_id) VALUES (1, 5);
INSERT INTO tb_deslike_movie (user_id, movie_id) VALUES (2, 5);
INSERT INTO tb_deslike_movie (user_id, movie_id) VALUES (2, 6);
INSERT INTO tb_deslike_movie (user_id, movie_id) VALUES (1, 6);
INSERT INTO tb_deslike_movie (user_id, movie_id) VALUES (1, 7);

INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (1, 1);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (1, 2);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (2, 1);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (2, 2);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (3, 3);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (4, 1);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (5, 1);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (6, 2);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (7, 1);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (8, 1);
INSERT INTO tb_movie_genre (movie_id, genre_id) VALUES (8, 2);

INSERT INTO tb_movie_topic (movie_id, topic_id) VALUES (1, 2);
INSERT INTO tb_movie_topic (movie_id, topic_id) VALUES (2, 2);
INSERT INTO tb_movie_topic (movie_id, topic_id) VALUES (3, 2);
INSERT INTO tb_movie_topic (movie_id, topic_id) VALUES (4, 2);
INSERT INTO tb_movie_topic (movie_id, topic_id) VALUES (5, 2);
INSERT INTO tb_movie_topic (movie_id, topic_id) VALUES (6, 2);
INSERT INTO tb_movie_topic (movie_id, topic_id) VALUES (7, 2);
INSERT INTO tb_movie_topic (movie_id, topic_id) VALUES (8, 2);

INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,1);
INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,2);
INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,3);
INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,4);
INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,5);
INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,6);
INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,7);
INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,8);
INSERT INTO tb_section_topic (section_id, topic_id) VALUES (2,9);

INSERT INTO tb_section_profile (section_id, profile_id) VALUES (1,2);
INSERT INTO tb_section_profile (section_id, profile_id) VALUES (1,3);
INSERT INTO tb_section_profile (section_id, profile_id) VALUES (1,4);
INSERT INTO tb_section_profile (section_id, profile_id) VALUES (1,5);
INSERT INTO tb_section_profile (section_id, profile_id) VALUES (1,6);








