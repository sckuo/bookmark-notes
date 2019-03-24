CREATE TABLE SYSTEM_PROPERTY (
	NAM_PROPERTY VARCHAR(255) UNIQUE NOT NULL,
	DES_VALUE TEXT,
	DAT_CREATION TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	DAT_UPDATE TIMESTAMP
);

INSERT INTO  SYSTEM_PROPERTY (NAM_PROPERTY, DES_VALUE, DAT_CREATION, DAT_UPDATE) VALUES ('CODE_BLOCK_MAX_HEIGHT', '250', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO  SYSTEM_PROPERTY (NAM_PROPERTY, DES_VALUE, DAT_CREATION, DAT_UPDATE) VALUES ('MOBILE_CODE_BLOCK_MAX_HEIGHT', '250', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
