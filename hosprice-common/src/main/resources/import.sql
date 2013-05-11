INSERT into PERSONS (personId, firstName, lastName) values (1001, 'Julie', 'Lambis');

INSERT into PERSONS (personId, firstName, lastName) values (1002, 'Tom', 'Crew');


INSERT into REGION ( regionId, name, state ) values (100,'DOTHAN' ,'AL');

INSERT into REGION (regionId, name, state) values (101,'BIRMINGHAM', 'AL');

INSERT into REGION (regionId, name, state) values (102,'SALISBURY', 'MD');



INSERT into ADDRESS (addressId,  address1, address2, city, state, zipcode ) values(201, '1108 ROSS CLARK CIRCLE', NULL, 'DOTHAN', 'AL', '36301');
INSERT into ADDRESS (addressId,  address1, address2, city, state, zipcode ) values(202, '2505 U S HIGHWAY 431 NORTH', NULL, 'BOAZ', 'AL', '35957');
INSERT into ADDRESS (addressId,  address1, address2, city, state, zipcode ) values(203, '801 MIDDLEFORD RD', NULL, 'SALISBURY', 'MD', '19973');

INSERT into PROVIDER (providerId, name, legacyId, addressId, regionId) values (401, 'SOUTHEAST ALABAMA MEDICAL CENTER', 10001,201, 100 );
INSERT into PROVIDER (providerId, name, legacyId, addressId, regionId) values (402, 'MARSHALL MEDICAL CENTER SOUTH', 10005,202, 101 );
INSERT into PROVIDER (providerId, name, legacyId, addressId, regionId) values (403, 'NANTICOKE MEMORIAL HOSPITAL', 80006,203, 102 );


