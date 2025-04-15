/**
 * 
 */
package de.selle.opi.utilities;

/**
 * 
 */
public enum CardServiceRequestType {
	/**
	 * Payment only. TotalAmount mandatory. SalesItems: optional (depending on the
	 * cards accepted by the system; if any fleet card with product restrictions,
	 * then it becomes mandatory). Loyalty: no. OriginalTransaction: no.
	 */
	CardPayment, 
	CardSwipe, 
	LoyaltySwipe, 
	CardPaymentLoyaltyAward, 
	LoyaltyAward, 
	CardPreAuthorisation,
	CardFinancialAdvice, CardPreAuthorisationLoyaltySwipe
}
