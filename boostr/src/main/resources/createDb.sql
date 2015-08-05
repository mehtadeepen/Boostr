-- Create DB
CREATE DATABASE IF NOT EXISTS `boostr` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `boostr`;

-- Create tables
CREATE TABLE IF NOT EXISTS `article` (
  `id`        INT(11)         NOT NULL  AUTO_INCREMENT,
  `category`  VARCHAR(45)     NOT NULL,
  `url`       VARCHAR(45)     NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `category_data` (
  `id`        INT(11)         NOT NULL      AUTO_INCREMENT,
  `name`      VARCHAR(45)     DEFAULT NULL,
  `value`     FLOAT           DEFAULT NULL,
  `user`      INT(11)         DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user`
    FOREIGN KEY (`id`)
    REFERENCES `user` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `user` (
  `uuid`      INT(11)   NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Create default data
LOCK TABLES `article` WRITE;
INSERT INTO `article`
  (`category`,  `url`)
VALUES
  ('Interest',    'http://www.econlib.org/library/Enc/InterestRates.html'),
  ('Interest',    'http://www.investopedia.com/terms/i/interestrate.asp'),
  ('Loans',       'https://www.moneyadviceservice.org.uk/en/articles/personal-loans'),
  ('Loans',       'http://www.learnvest.com/knowledge-center/understanding-student-loans-101/'),
  ('Credit Card', 'http://www.consumer.ftc.gov/articles/0205-using-credit-card'),
  ('Credit Card', 'http://www.nerdwallet.com/blog/tips/rewards-credit-card-tips/pros-cons-shopping-credit-card/'),
  ('Savings',     'http://www.investopedia.com/articles/pf/08/save-without-trying.asp'),
  ('Savings',     'http://www.americasaves.org/for-savers/make-a-plan-how-to-save-money/54-ways-to-save-money'),
  ('Investing',   'http://www.thestreet.com/story/11748100/1/how-to-invest--ways-to-make-your-money-grow.html'),
  ('Investing',   'http://www.schwab.com/public/schwab/investing/retirement_and_planning/how_to_invest/types_of_investments'),
  ('Retirement',  'https://www.ameriprise.com/research-market-insights/financial-articles/retirement/retirement-planning-basics/'),
  ('Retirement',  'http://www.schwab.com/public/schwab/nn/articles/The-Five-Big-Lies-of-Retirement-Planning'),
  ('Help',        'http://elitedaily.com/life/the-20-mistakes-you-dont-want-to-make-in-your-20s/'),
  ('Help',        'http://www.businessinsider.com/mark-cuban-advice-for-20-somethings-2015-4'),
  ('Help',        'http://www.kiplinger.com/article/saving/T063-C006-S001-10-financial-commandments-for-your-20s.html');
UNLOCK TABLES;
