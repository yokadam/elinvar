package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class LoadHandler {

	private static final int MAX_PRICE_UPDATES = 100;
	private final Consumer consumer;
	private static int retryCount = 0;
	private static Map<String, PriceUpdate> map = new HashMap<>();

	public LoadHandler(Consumer consumer) {
		this.consumer = consumer;
	}

	public static void resetCounter() {
		retryCount = 0;
	}

	public void receive(PriceUpdate priceUpdate) {

		if (retryCount < MAX_PRICE_UPDATES) {
			retryCount++;
			System.out.println("-----PriceUpdate:" + retryCount + " -----");
			
			if (map.containsKey(priceUpdate.getCompanyName())) {
				map.replace(priceUpdate.getCompanyName(), priceUpdate);
			} else {
				map.put(priceUpdate.getCompanyName(), priceUpdate);
			}

			List<PriceUpdate> newList = map.entrySet().stream()
					.map(map -> map.getValue())
					.collect(toList());
			
			consumer.send(newList);
		}
	}
}
