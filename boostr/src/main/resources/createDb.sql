-- Create DB
CREATE DATABASE IF NOT EXISTS `boostr` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `boostr`;

-- Create tables
DROP TABLE `db_article`;
CREATE TABLE IF NOT EXISTS `db_article` (
  `id`        INT(11)         NOT NULL  AUTO_INCREMENT,
  `category`  VARCHAR(45)     NOT NULL,
  `url`       VARCHAR(150)    NOT NULL,
  `author`    VARCHAR(45)     NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE `db_category_data`;
CREATE TABLE IF NOT EXISTS `db_category_data` (
  `id`        INT(11)         NOT NULL      AUTO_INCREMENT,
  `name`      VARCHAR(45)     DEFAULT NULL,
  `value`     FLOAT           DEFAULT NULL,
  `user`      INT(11)         DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user`
    FOREIGN KEY (`id`)
    REFERENCES `db_user` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE `db_user`;
CREATE TABLE IF NOT EXISTS `db_user` (
  `uuid`      INT(11)   NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Create default data
LOCK TABLES `db_article` WRITE;
INSERT INTO `db_article`
  (`category`,    `author`, `url`)
VALUES
  ('Interest',    'Burton G. Malkiel',          'http://www.econlib.org/library/Enc/InterestRates.html'),
  ('Interest',    'Investopedia',               'http://www.investopedia.com/terms/i/interestrate.asp'),
  ('Loans',       'The Money Advice Service',   'https://www.moneyadviceservice.org.uk/en/articles/personal-loans'),
  ('Loans',       'Laura Shin',                 'http://www.learnvest.com/knowledge-center/understanding-student-loans-101/'),
  ('Credit Card', 'Federal Trade Commission',   'http://www.consumer.ftc.gov/articles/0205-using-credit-card'),
  ('Credit Card', 'Stephan Vanderpool',         'http://www.nerdwallet.com/blog/tips/rewards-credit-card-tips/pros-cons-shopping-credit-card/'),
  ('Savings',     'Glenn Curtis',               'http://www.investopedia.com/articles/pf/08/save-without-trying.asp'),
  ('Savings',     'America Saves',              'http://www.americasaves.org/for-savers/make-a-plan-how-to-save-money/54-ways-to-save-money'),
  ('Investing',   'John DeFeo',                 'http://www.thestreet.com/story/11748100/1/how-to-invest--ways-to-make-your-money-grow.html'),
  ('Investing',   'Charles Schwab',             'http://www.schwab.com/public/schwab/investing/retirement_and_planning/how_to_invest/types_of_investments'),
  ('Retirement',  'Ameriprise',                 'https://www.ameriprise.com/research-market-insights/financial-articles/retirement/retirement-planning-basics/'),
  ('Retirement',  'Rande Spiegelman',           'http://www.schwab.com/public/schwab/nn/articles/The-Five-Big-Lies-of-Retirement-Planning'),
  ('Help',        'Elite Daily Staff',          'http://elitedaily.com/life/the-20-mistakes-you-dont-want-to-make-in-your-20s/'),
  ('Help',        'Richard Feloni',             'http://www.businessinsider.com/mark-cuban-advice-for-20-somethings-2015-4'),
  ('Help',        'Stacy Rapacon',              'http://www.kiplinger.com/article/saving/T063-C006-S001-10-financial-commandments-for-your-20s.html');
UNLOCK TABLES;


