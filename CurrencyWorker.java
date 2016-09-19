package conversion;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyWorker.
 */
public class CurrencyWorker extends SwingWorker<Void, Void> {

	/**
	 * Instantiates a new currency worker.
	 *
	 * @param currencyType the currency type
	 * @param strUSDAmt the str usd amt
	 * @param jlblConvertedAmt the jlbl converted amt
	 */
	public CurrencyWorker(String currencyType, String strUSDAmt, JLabel jlblConvertedAmt) {
		
		this.currencyType = currencyType;
		this.strUSDAmt = strUSDAmt;
		this.jlblConvertedAmt = jlblConvertedAmt;
	}

	/* (non-Javadoc)
	 * @see javax.swing.SwingWorker#doInBackground()
	 */
	@Override
	protected Void doInBackground() throws Exception {

		this.calculateConversion();
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.SwingWorker#done()
	 */
	@Override
	protected void done() {
		this.jlblConvertedAmt.setText(String.valueOf(this.currencyConverted));
	}

	/**
	 * Calculate conversion.
	 */
	private void calculateConversion() {

		this.currencyConverted = Double.parseDouble(this.strUSDAmt.trim())
				/ Double.parseDouble(CurrencyProperties.getRef().getProperty(this.currencyType.trim()));
	}

	/** The currency converted. */
	private double currencyConverted;
	
	/** The currency type. */
	private String currencyType;
	
	/** The usd amt. */
	private String strUSDAmt;
	
	/** The jlbl converted amt. */
	private JLabel jlblConvertedAmt;
}
