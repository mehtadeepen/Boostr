-- Create DB
DROP DATABASE IF EXISTS `boostr`;
CREATE DATABASE IF NOT EXISTS `boostr` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `boostr`;

-- Create tables
CREATE TABLE IF NOT EXISTS `db_article` (
  `id`        INT(11)         NOT NULL  AUTO_INCREMENT,
  `category`  VARCHAR(45)     NOT NULL,
  `title`     VARCHAR(30)     NOT NULL,
  `url`       VARCHAR(150)    NOT NULL,
  `author`    VARCHAR(45)     NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `db_user` (
  `uuid`      VARCHAR(30)     NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `db_category_data` (
  `name`      VARCHAR(45)     NOT NULL,
  `value`     FLOAT           NOT NULL,
  `user`      VARCHAR(30)     NOT NULL,
  PRIMARY KEY (`name`, `user`),
  CONSTRAINT `fk_user`
  FOREIGN KEY (`user`)
  REFERENCES `boostr`.`db_user` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Create default data
LOCK TABLES `db_article` WRITE;
INSERT INTO `db_article`
(`category`,      `author`,                     `title`,                                                `url`)
VALUES
  ('Interest',    'Burton G. Malkiel',          'Interest Rates',                                       'http://www.econlib.org/library/Enc/InterestRates.html'),
  ('Interest',    'Investopedia',               'Interest Rate',                                        'http://www.investopedia.com/terms/i/interestrate.asp'),
  ('Loans',       'The Money Advice Service',   'Personal Loans',                                       'https://www.moneyadviceservice.org.uk/en/articles/personal-loans'),
  ('Loans',       'Laura Shin',                 'Understanding Student Loans',                          'http://www.learnvest.com/knowledge-center/understanding-student-loans-101/'),
  ('Credit Card', 'Federal Trade Commission',   'Using a Credit Card',                                  'http://www.consumer.ftc.gov/articles/0205-using-credit-card'),
  ('Credit Card', 'Stephan Vanderpool',         'Pros and Cons of Shopping with a Credit Card',         'http://www.nerdwallet.com/blog/tips/rewards-credit-card-tips/pros-cons-shopping-credit-card/'),
  ('Savings',     'Glenn Curtis',               '5 Painless Ways to Save More Money',                   'http://www.investopedia.com/articles/pf/08/save-without-trying.asp'),
  ('Savings',     'America Saves',              '52 Ways to Save Money',                                'http://www.americasaves.org/for-savers/make-a-plan-how-to-save-money/54-ways-to-save-money'),
  ('Investing',   'John DeFeo',                 'How to Invest - Basic Investing Strategies',           'http://www.thestreet.com/story/11748100/1/how-to-invest--ways-to-make-your-money-grow.html'),
  ('Investing',   'Charles Schwab',             'Types of Investments',                                 'http://www.schwab.com/public/schwab/investing/retirement_and_planning/how_to_invest/types_of_investments'),
  ('Retirement',  'Ameriprise',                 'Retirement Planning: The Basics',                      'https://www.ameriprise.com/research-market-insights/financial-articles/retirement/retirement-planning-basics/'),
  ('Retirement',  'Rande Spiegelman',           'The Five Big Lies of Retirement Planning',             'http://www.schwab.com/public/schwab/nn/articles/The-Five-Big-Lies-of-Retirement-Planning'),
  ('Help',        'Elite Daily Staff',          '20 Mistakes You Dont Want To Make in Your 20s',        'http://elitedaily.com/life/the-20-mistakes-you-dont-want-to-make-in-your-20s/'),
  ('Help',        'Richard Feloni',             'Mark Cuban Shares His Top 5 Tips For 20-Somethings',   'http://www.businessinsider.com/mark-cuban-advice-for-20-somethings-2015-4'),
  ('Help',        'Stacy Rapacon',              '10 Financial Commandments For Your 20s',               'http://www.kiplinger.com/article/saving/T063-C006-S001-10-financial-commandments-for-your-20s.html');
UNLOCK TABLES;


