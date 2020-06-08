SELECT productCode from product_goods  where tenantId='4c1a45f1-d809-4965-b99d-1b2d5fa87e6b' GROUP BY productCode;

SELECT * from product where tenantId='4c1a45f1-d809-4965-b99d-1b2d5fa87e6b' and code not in (
SELECT productCode from product_goods  where tenantId='4c1a45f1-d809-4965-b99d-1b2d5fa87e6b' GROUP BY productCode
);

 DELETE from product where tenantId='4c1a45f1-d809-4965-b99d-1b2d5fa87e6b'  and code not in (
 SELECT productCode from product_goods  where tenantId='4c1a45f1-d809-4965-b99d-1b2d5fa87e6b' GROUP BY productCode
);