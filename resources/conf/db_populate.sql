
INSERT INTO `carloan`.`agenzia` VALUES
	('1', 'Bari', 'via Cavour 5', '080111111'),
	('2', 'Foggia', 'corso Roma 79', '088122222'),
	('3', 'Lecce', 'via Orabona 3', '333000000'),
	('4', 'Brindisi', 'viale Ofanto 43', '347444444');

INSERT INTO `carloan`.`fascia` VALUES
	('A', 'sportiva', 20.00, 10.00, 30.00),
	('B', 'suv', 20.00, 10.00, 30.00),
	('C', 'berlina', 20.00, 10.00, 30.00),
	('D', 'utilitaria', 20.00, 10.00, 30.00);

INSERT INTO `carloan`.`stato` VALUES
	('N', 'non disponibile'),
	('D', 'disponibile'),
	('M', 'in manutenzione');

INSERT INTO `carloan`.`account` VALUES
	('admin', 'admin', 'admin'),
	('manager002', 'manag', 'manager'),
	('imp001', 'impie', 'impiegato'),
	('rob002', 'fghil', 'impiegato'),
	('pier001', '22222', 'manager'),
	('fer003', '55555', 'impiegato'),
	('raff003', '77777', 'manager'),
	('franc001', 'frgth', 'impiegato'),
	('fel003', 'htgrf', 'impiegato'),
	('ger002', 'aaaaa', 'impiegato');

INSERT INTO `carloan`.`cliente` VALUES
	('SFREDS13A01D447S ', 'Roberto', 'Rossi', '1980-11-21', '08034111'),
	('XWESUG13A01D447S ', 'Giovanni', 'Gialli', '1978-12-30', '08056111'),
	('QWERTY13A01D447S ', 'Susanna', 'Verdi', '1991-09-01', '08078111'),
	('FRANZS13A01D447S ', 'Francesca', 'Bianchi', '1953-03-14', '08090111');

INSERT INTO `carloan`.`auto` VALUES
	('af111jv ', 'Mercedes SL',        'D', 'A', '0',        '2016-03-14', '001'),
	('wc333jh ', 'Chevrolet Corvette', 'D', 'A', '20000',    '2016-12-30', '003'),
	('tz444lk ', 'Porsche Cayman',     'N', 'A', '700950',   '2016-09-01', '002'),
	('hb555ei ', 'Ford Mustang',       'D', 'A', '7000',     '2015-12-14', '004'),
	('bc333jh ', 'BMW X1',             'D', 'B', '20',       '2015-12-30', '001'),
	('vz444lk ', 'Audi Q3',            'N', 'B', '700',      '2016-09-30', '002'),
	('re555ei ', 'Volkswagen Touareg', 'M', 'B', '10000',    '2015-11-14', '003'),
	('er511tt ', 'Dodge Durango',      'D', 'B', '3000',     '2016-05-14', '004'),
	('cq144ez ', 'Audi A3',            'D', 'C', '7000',     '2016-03-14', '001'),
	('mn732ey ', 'Chevrolet SS',       'D', 'C', '5000',     '2016-03-14', '002'),
	('nm345aq ', 'Ford Fiesta',        'N', 'C', '0',        '2016-03-14', '003'),
	('kj088fv ', 'Honda Civic',        'D', 'C', '800',      '2016-03-14', '004'),
	('jk890uj ', 'Nissan Micra',       'D', 'D', '300',      '2016-01-23', '003'),
	('pp123yi ', 'Peugeot 206',        'D', 'D', '4500',     '2016-08-19', '002'),
	('ui234ef ', 'Skoda Fabia',        'M', 'D', '11000',    '2015-11-01', '001'),
	('yy432oo ', 'Hyundai i10',        'N', 'D', '3007',     '2016-03-15', '004');
