-- Plugin installation
DELETE FROM core_datastore WHERE entity_key = 'core.plugins.status.leaflet-sira.installed';
INSERT INTO core_datastore(entity_key,entity_value) VALUES ('core.plugins.status.leaflet-dansmarue.installed','true');