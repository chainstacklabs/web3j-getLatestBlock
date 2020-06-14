# web3j example to get the latest block on Ethereum or Quorum

An example [web3j](https://github.com/web3j/web3j) application to interact with your Ethereum or Quorum node deployed with Chainstack.

Running the application will:

1. Connect to your Ethereum node or Quorum node with basic authentication.
1. Run the function [ethGetBlockByNumber](https://javadoc.io/static/org.web3j/core/4.5.8/org/web3j/protocol/core/JsonRpc2_0Web3j.html#ethGetBlockByNumber-org.web3j.protocol.core.DefaultBlockParameter-boolean-).
1. Print the latest block number.

## Requirements

1. Java 1.8+
1. Maven

## Steps

1. In `src/main/java/getLatestBlock/App.java`, repace `RPC_USERNAME`, `RPC_PASSWORD`, and `RPC_ENDPOINT` with your [access and credentials](https://docs.chainstack.com/platform/view-node-access-and-credentials).
1. In the root directory, run `mvn package`. This will build the app in the `target` directory.
1. Change to the `target` directory and run `java -jar web3j-getLatestBlock-1-jar-with-dependencies.jar`.
