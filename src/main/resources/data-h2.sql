
DELETE FROM users;
INSERT INTO users
(
  NAME,
  EMAIL,
  ADDRESS_LINE_ONE,
  ADDRESS_LINE_TWO,
  TOWN_CITY,
  POSTAL_CODE,
  COUNTRY,
  PHONE_NUMBER_1,
  PHONE_NUMBER_2,
  PHONE_NUMBER_3,
  DATE_LAST_VIEW)
VALUES
  (
    'ciro',
    'ciro@ciro.it',
    ', Marvel street',
    null,
    'New York',
    ' yor 12',
    'USA',
    NULL,
    null,
    NULL,
    CURRENT_TIMESTAMP());