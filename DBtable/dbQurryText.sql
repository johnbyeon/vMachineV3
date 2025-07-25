CREATE TABLE credit_card(
cre_num INT PRIMARY KEY NOT NULL AUTO_INCREMENT, #카드등록번호(거래용으로 등록된 카드의 순서)
cre_cus_num INT NOT NULL, #카드를 보유한 유저의 번호
cre_card_num VARCHAR(16) NOT NULL, # 카드는 번호는 16자리 '-' 하이픈 제거 후 입력 출력
cre_card_balance INT NOT NULL DEFAULT 0, #충전 카드 잔액
cre_first_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, #카드 만들시 자동으로 첫날 등록
cre_use_status INT NOT NULL DEFAULT 0 #사용여부 등록 기록안하고 등록시 기본 0 사용시 1
);

CREATE TABLE payment_history(
pay_num INT PRIMARY KEY NOT NULL AUTO_INCREMENT, #결제내역번호(장부 번호)
pay_cre_num INT NOT NULL, # 카드등록번호
pay_stauts INT NOT NULL DEFAULT 1, #결제 상태 "정상","취소","충전" 등..
pay_amount INT NOT NULL,  #결제,충전,취소의 금액
pay_balance INT NOT NULL, #결제시 총 누적금액
pay_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP  #결제한 날짜
);

CREATE TABLE accounting_book(
acnt_num INT PRIMARY KEY NOT NULL AUTO_INCREMENT, #거래번호 (장부번호)
acnt_cus_num INT NOT NULL, #거래자
acnt_pay_num INT NOT NULL, #결제내역번호 (안에 카드정보,가격,누적금액 등이 들어있음)
acnt_product_num INT NOT NULL, #거래한 물품번호
acnt_product_count INT NOT NULL DEFAULT 1 #거래한 물품 수 최소 1개이상
);


CREATE TABLE User(
cus_num INT PRIMARY NOT NULL KEY AUTO_INCREMENT,
cus_id VARCHAR(20) NOT NULL,
cus_password CHAR(64) NOT NULL,
cus_name VARCHAR(15),
cus_phone VARCHAR(13),
cus_main_card_num INT NOT NULL DEFAULT 1,
cus_first_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
cus_last_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE product(
product_num INT PRIMARY NOT NULL KEY AUTO_INCREMENT,
product_name VARCHAR(20) NOT NULL,
product_display_count INT NOT NULL DEFAULT 0,
product_add_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
product_update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
product_inventory_count INT NOT NULL DEFAULT 0,
product_price INT NOT NULL DEFAULT 0
);


ALTER TABLE `machine_v3_db`.`accounting_book`
DROP FOREIGN KEY `cus num`,
DROP FOREIGN KEY `pay num`,
DROP FOREIGN KEY `product num`;
ALTER TABLE `machine_v3_db`.`accounting_book`
ADD CONSTRAINT `cus num`
  FOREIGN KEY (`acnt_cus_num`)
  REFERENCES `machine_v3_db`.`user` (`cus_num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `pay num`
  FOREIGN KEY (`acnt_pay_num`)
  REFERENCES `machine_v3_db`.`payment_history` (`pay_num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `product num`
  FOREIGN KEY (`acnt_product_num`)
  REFERENCES `machine_v3_db`.`product` (`product_num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;



ALTER TABLE `machine_v3_db`.`credit_card`
DROP FOREIGN KEY `User num`;
ALTER TABLE `machine_v3_db`.`credit_card`
ADD CONSTRAINT `User num`
  FOREIGN KEY (`cre_cus_num`)
  REFERENCES `machine_v3_db`.`user` (`cus_num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `machine_v3_db`.`payment_history`
ADD INDEX `credit num_idx` (`pay_cre_num` ASC) VISIBLE;
;
ALTER TABLE `machine_v3_db`.`payment_history`
ADD CONSTRAINT `credit num`
  FOREIGN KEY (`pay_cre_num`)
  REFERENCES `machine_v3_db`.`credit_card` (`cre_num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
