package ntushares.rates.chronejob;

import java.util.Timer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Timer t = new Timer();
         FetchCurrencyRatesTask fetchCurrencyRatesTask = new FetchCurrencyRatesTask();

         t.scheduleAtFixedRate(fetchCurrencyRatesTask, 0, 86400000);
       }
    }

