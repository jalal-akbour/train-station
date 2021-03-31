package fr.train_station.constants;

/**
 * [Pricing]
 * We charge in euros (€), a euro has 100 cents.
 * 1) Travel within zones 1 and 2: €2.40 per trip.
 * 2) Travel within zones 3 and 4: €2.00 per trip.
 * 3) Travel from zone 3 to zone 1 or 2: €2.80 per trip.
 * 4) Travel from zone 4 to Zone 1 or 2: €3.00 per trip.
 * 5) Travel from zone 1 or 2, to zone 3: €2.80 per trip.
 * 6) Travel from zone 1 or 2, zone 4 to: €3.00 per trip.
 * 7) If there is the possibility of two prices then we must charge the customer the lowest amount and reflect this in the pricing information.
 */

public enum Pricing {

    tripInsideZone1(Zone.zone1,Zone.zone1,240),
    tripInsideZone2(Zone.zone2,Zone.zone2,240),
    tripInsideZone3(Zone.zone3,Zone.zone3,200),
    tripInsideZone4(Zone.zone4,Zone.zone4,200),

    tripFromZone1ToZone2(Zone.zone1,Zone.zone2,240),
    tripFromZone2ToZone1(Zone.zone2,Zone.zone1,240),

    tripFromZone3ToZone4(Zone.zone3,Zone.zone4,200),
    tripFromZone4ToZone3(Zone.zone4,Zone.zone3,200),

    tripFromZone3ToZone1(Zone.zone3,Zone.zone1,280),
    tripFromZone3ToZone2(Zone.zone3,Zone.zone2,280),

    tripFromZone4ToZone1(Zone.zone4,Zone.zone1,300),
    tripFromZone4ToZone2(Zone.zone4,Zone.zone2,300),

    tripFromZone1ToZone3(Zone.zone1,Zone.zone3,280),
    tripFromZone2ToZone3(Zone.zone2,Zone.zone3,280),

    tripFromZone1ToZone4(Zone.zone1,Zone.zone4,300),
    tripFromZone2ToZone4(Zone.zone2,Zone.zone4,300),



    ;

    public final Zone zoneStart;
    public final Zone zoneEnd;
    public final int tripPrice;



    Pricing(Zone zoneStart, Zone zoneEnd, int tripPrice){
        this.zoneStart = zoneStart;
        this.zoneEnd = zoneEnd;
        this.tripPrice = tripPrice;
    }
}
