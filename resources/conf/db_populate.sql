
INSERT INTO `carloan`.`agenzia` VALUES
	('1', 'Bari',     'via Cavour 5',    '080111111'),
	('2', 'Foggia',   'corso Roma 79',   '088122222'),
	('3', 'Lecce',    'via Orabona 3',   '333000000'),
	('4', 'Brindisi', 'viale Ofanto 43', '347444444');

INSERT INTO `carloan`.`fascia` VALUES
	('A', 'sportiva',   20.00, 10.00, 30.00),
	('B', 'suv',        20.00, 10.00, 30.00),
	('C', 'berlina',    20.00, 10.00, 30.00),
	('D', 'utilitaria', 20.00, 10.00, 30.00);

INSERT INTO `carloan`.`stato` VALUES
	('N', 'non disponibile'),
	('D', 'disponibile'),
	('M', 'in manutenzione');

INSERT INTO `carloan`.`account` VALUES
	('admin',      'admin', 'admin'),
	('manag',      'manag', 'manager'),
	('impie',      'impie', 'impiegato'),
	('rol001',     'fghil', 'impiegato'),
	('pier003',    '22222', 'manager'),
	('fer001',     '55555', 'impiegato'),
	('raff002',    '77777', 'manager'),
	('franc002',   'frgth', 'impiegato'),
	('fel002',     'htgrf', 'impiegato'),
	('ger002',     'aaaaa', 'impiegato'),
	('ern003',     'ghjkl', 'impiegato'),
	('manager004', 'qwert', 'manager'),
	('rin003',     'reqty', 'impiegato'),
	('www003',     'uiopl', 'impiegato'),
	('tre004',     'reqty', 'impiegato'),
	('frz004',     'mrzzr', 'impiegato'),
	('qqq004',     'huooh', 'impiegato');

INSERT INTO `carloan`.`cliente` VALUES
	('SFREDS13A01D447S ', 'Roberto',   'Rossi',   '1980-11-21', '08034111'),
	('XWESUG13A01D447S ', 'Giovanni',  'Gialli',  '1978-12-30', '08056111'),
	('QWERTY13A01D447S ', 'Susanna',   'Verdi',   '1991-09-01', '08078111'),
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

INSERT INTO `carloan`.`impiegato` VALUES
	('RFLFRT13A01D332K ', 'Raffaele',   'Fratta',   '1970-12-11', '08034333', '001', 'manag'),
	('DNTRMN13D14C931Z ', 'Donato',     'Romani',   '1979-02-10', '08056444', '002', 'impie'),
	('ABRBRS13G71F145H ', 'Alberto',    'Baresi',   '1992-07-07', '08078555', '003', 'rol001'),
	('BRNSPN13A35T417Q ', 'Bernardo',   'Spine',    '1957-03-14', '08090454', '004', 'fer001'),
	('MRCCRX13A01D332Y ', 'Marcello',   'Cori',     '1984-10-21', '08034777', '001', 'raff002'),
	('FDRCST13D14C931T ', 'Federica',   'Celesti',  '1971-05-30', '08056134', '002', 'franc002'),
	('MRTLMB13G71F145S ', 'Martina',    'Lombardo', '1991-05-01', '08078788', '003', 'fel002'),
	('PLDEDS13A01D332R ', 'Paolo',      'di Cagno', '1983-12-21', '08034123', '004', 'ger002'),
	('LCFRFZ13D14C931W ', 'Luca',       'Frizzo',   '1975-11-30', '08056321', '001', 'pier003'),
	('ASNSFR13G71F145P ', 'Alessandra', 'Sfrizzo',  '1981-02-05', '08078345', '002', 'ern003'),
	('RBRBRS13G71F145H ', 'Robert',     'Carli',    '1972-04-07', '08078575', '003', 'rin003'),
	('CLNSPN13A35T417Q ', 'Carlo',      'Roberti',  '1967-05-14', '08090414', '004', 'www003'),
	('FBZCRX13A01D332Y ', 'Fabrizio',   'Frizi',    '1987-10-27', '08034737', '001', 'manager004'),
	('GVNCST13D14C931T ', 'GiOvanna',    'Sedia',    '1979-05-30', '08056704', '002', 'tre004'),
	('ENSLMB13G71F145S ', 'Ernesto',    'Mafelcio', '1951-05-05', '08078058', '003', 'frz004'),
	('PINEDS13A01D332R ', 'Pina',       'Inglese',  '1989-12-21', '08031023', '004', 'qqq004'),
	('FRNLMB13G71F145S ', 'Franco',     'Franchi',  '1971-07-03', '08041058', '001', 'admin');