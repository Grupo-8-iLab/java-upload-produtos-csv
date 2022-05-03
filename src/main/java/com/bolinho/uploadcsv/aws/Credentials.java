package com.bolinho.uploadcsv.aws;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public class Credentials {
	public static AwsCredentialsProvider getCredentials() {

		AwsCredentialsProvider credentials = new AwsCredentialsProvider() {

			@Override
			public AwsCredentials resolveCredentials() {
				return new AwsCredentials() {

					@Override
					public String accessKeyId() {
						return System.getenv("AWS_ACCESS_KEY_ID");
					}

					@Override
					public String secretAccessKey() {
						return System.getenv("AWS_SECRET_KEY");
					}

				};
			}

		};
		return credentials;
	}
}
