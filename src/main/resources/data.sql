insert into person (id, name) values
                                            (gen_random_uuid(), 'Jan Kowalski'),
                                            (gen_random_uuid(), 'Marek Nowak'),
                                            (gen_random_uuid(), 'Anna Tomaszewska'),
                                            (gen_random_uuid(), 'Diana Dąbrowska'),
                                            (gen_random_uuid(), 'Paweł Król');

insert into person (id, name) values
                                            (gen_random_uuid(), 'Anna Kowalska'),
                                            (gen_random_uuid(), 'Maria Nowak'),
                                            (gen_random_uuid(), 'Tomasz Tomaszewski'),
                                            (gen_random_uuid(), 'Jan Dąbrowski'),
                                            (gen_random_uuid(), 'Marta Król');

insert into students (student_id) values ((select id from person where name = 'Jan Kowalski')),
                                ((select id from person where name = 'Marek Nowak')),
                                ((select id from person where name = 'Anna Tomaszewska')),
                                ((select id from person where name = 'Diana Dąbrowska')),
                                ((select id from person where name = 'Paweł Król'));

insert into teachers (teacher_id) values ((select id from person where name = 'Anna Kowalska')),
                                ((select id from person where name = 'Maria Nowak')),
                                ((select id from person where name = 'Tomasz Tomaszewski')),
                                ((select id from person where name = 'Jan Dąbrowski')),
                                ((select id from person where name = 'Marta Król'));

insert into exams (id, name, score, student_student_id, teacher_teacher_id) values
                                            (gen_random_uuid(), 'Matematyka', '5.0', (select id from person where name = 'Jan Kowalski'), (select id from person where name = 'Marta Król')),
                                            (gen_random_uuid(), 'Historia', '4.5', (select id from person where name = 'Marek Nowak'), (select id from person where name = 'Jan Dąbrowski')),
                                            (gen_random_uuid(), 'Fizyka', '3.5', (select id from person where name = 'Anna Tomaszewska'), (select id from person where name = 'Tomasz Tomaszewski')),
                                            (gen_random_uuid(), 'Biologia', '4.0', (select id from person where name = 'Diana Dąbrowska'), (select id from person where name = 'Maria Nowak')),
                                            (gen_random_uuid(), 'Geografia', '3.0', (select id from person where name = 'Paweł Król'), (select id from person where name = 'Anna Kowalska'));