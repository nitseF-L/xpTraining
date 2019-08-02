CREATE TABLE GameResultIdSeq (id INT NOT NULL);
INSERT INTO GameResultIdSeq VALUES (0);

delimiter //
create function GameResultIdSeqValue() returns int
begin
 update GameResultIdSeq set id=last_insert_id(id+1);
 return last_insert_id();
end
//

delimiter ;