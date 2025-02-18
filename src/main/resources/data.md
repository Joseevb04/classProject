-- Insert test data into the book table
--
-- INSERT INTO book (title, release_year, genre_id, author, language, synopsis, created_at) VALUES
-- ('El Quijote', 1605, 'ADVENTURE', 'Miguel de Cervantes', 'ES', 'Un caballero y su escudero en aventuras épicas.', '2025-01-01'),
-- ('1984', 1949, 'SCI_FI', 'George Orwell', 'EN', 'Una distopía sobre el control y la vigilancia.', '2025-01-01'),
-- ('Os Lusiadas', 1572, 'FANTASY', 'Luís de Camões', 'PT', 'Una epopeya sobre los exploradores portugueses.', '2025-01-01'),
-- ('Don Juan Tenorio', 1844, 'DRAMA', 'José Zorrilla', 'ES', 'Un drama romántico clásico español.', '2025-01-01'),
-- ('O Apóstolo', 2012, 'HORROR', 'Fernando Cortizo', 'GA', 'Un thriller sobrenatural en Galicia.', '2025-01-01'),
-- ('Pride and Prejudice', 1813, 'ROMANCE', 'Jane Austen', 'EN', 'Una historia de amor y malentendidos en la Inglaterra del siglo XIX.', '2025-01-01'),
-- ('The Murder of Roger Ackroyd', 1926, 'MYSTERY', 'Agatha Christie', 'EN', 'Un caso intrigante resuelto por Hercule Poirot.', '2025-01-01'),
-- ('Los Crímenes de la Calle Morgue', 1841, 'CRIME', 'Edgar Allan Poe', 'ES', 'El primer misterio de asesinato moderno.', '2025-01-01'),
-- ('La Sombra del Viento', 2001, 'THRILLER', 'Carlos Ruiz Zafón', 'ES', 'Un thriller literario ambientado en Barcelona.', '2025-01-01'),
-- ('Dune', 1965, 'SCI_FI', 'Frank Herbert', 'EN', 'Una obra maestra de la ciencia ficción sobre política y ecología.', '2025-01-01');
--
-- insert into book (title, release_year, genre_id, author, language, synopsis, created_at, image_url) VALUES
-- ('test', 2000, 'SCI_FI', 'test', 'ES', 'test', '2025-01-01', '1739820077337.png');

 
INSERT INTO users (id, username, password) VALUES 
(1, 'user1', 'password1'),
(2, 'user2', 'password2'),
(3, 'user3', 'password3'),
(4, 'user4', 'password4'),
(5, 'user5', 'password5');


INSERT INTO rating (user_id, book_id, rating, comment) VALUES 
(1, 1, 5, 'Una obra maestra de la literatura española.'),
(2, 2, 4, 'Un libro visionario y perturbador.'),
(3, 3, 5, 'Un clásico de la poesía épica.'),
(4, 4, 3, 'Interesante, pero un poco anticuado.'),
(5, 5, 4, 'Me encantó el ambiente oscuro.'),
(1, 6, 5, 'Una historia romántica excelente.'),
(2, 7, 4, 'Un misterio muy bien construido.'),
(3, 8, 5, 'Un relato fascinante y pionero.'),
(4, 9, 4, 'Un thriller envolvente y emocionante.'),
(5, 10, 5, 'Una obra maestra de la ciencia ficción.');

