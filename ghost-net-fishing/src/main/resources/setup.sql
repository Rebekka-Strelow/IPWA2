-- Erstelle die Tabelle Person
CREATE TABLE `person` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `password` VARCHAR(255) NOT NULL, -- Hash des Passworts
    `name` VARCHAR(255) NOT NULL,
    `vorname` VARCHAR(255) NOT NULL,
    `telefonnummer` VARCHAR(20) NULL -- Kann NULL sein
);

-- Erstelle die Tabelle Rolle
CREATE TABLE `rolle` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `bezeichnung` VARCHAR(255) NOT NULL
);

-- N:M Beziehung zwischen Person und Rolle
CREATE TABLE `person_rolle` (
    `person_id` INT,
    `rolle_id` INT,
    PRIMARY KEY (`person_id`, `rolle_id`),
    FOREIGN KEY (`person_id`) REFERENCES `person`(`id`),
    FOREIGN KEY (`rolle_id`) REFERENCES `rolle`(`id`)
);

-- Erstelle die Tabelle `netz`
CREATE TABLE `netz` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `standort` POINT NOT NULL, -- Speichert GPS-Koordinaten
    `groesse` FLOAT NOT NULL, -- Größe des Netzes
    `verschollen_gemeldet_durch` INT NULL, -- Kann NULL sein
    `bergung_bevorstehend_durch` INT NULL, -- Kann NULL sein
    `gemeldet_von` INT NULL, -- Kann NULL sein
    `geborgen_durch` INT NOT NULL, -- Muss ausgefüllt werden
    FOREIGN KEY (`verschollen_gemeldet_durch`) REFERENCES `person`(`id`),
    FOREIGN KEY (`bergung_bevorstehend_durch`) REFERENCES `person`(`id`),
    FOREIGN KEY (`gemeldet_von`) REFERENCES `person`(`id`),
    FOREIGN KEY (`geborgen_durch`) REFERENCES `person`(`id`)
);