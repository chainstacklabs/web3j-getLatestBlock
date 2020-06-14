package getLatestBlock;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.exceptions.ClientConnectionException;
import org.web3j.protocol.http.HttpService;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public final class App {

	private static final String USERNAME = "RPC_USERNAME";
	private static final String PASSWORD = "RPC_PASSWORD";
	private static final String RPC_ENDPOINT = "RPC_ENDPOINT";

	public static void main(String[] args) {
		try {
			
			OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
			clientBuilder.authenticator(new Authenticator() {
			    @Override public Request authenticate(Route route, Response response) throws IOException {
			        String credential = Credentials.basic(USERNAME, PASSWORD);
			        return response.request().newBuilder().header("Authorization", credential).build();
			    }
			});
			
			HttpService service = new HttpService(RPC_ENDPOINT, clientBuilder.build(), false);
			Web3j web3 = Web3j.build(service);

			
			EthBlock.Block latestBlock = web3.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, false).send().getBlock();

			
			System.out.println("Latest Block: #" + latestBlock.getNumber());

		} catch (IOException | ClientConnectionException ex) {
			
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
