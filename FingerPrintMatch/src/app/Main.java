package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

public class Main {

	public static void main(String[] args) {
		byte[] probeImage = null, candidateImage = null;
		try {
			probeImage = Files.readAllBytes(Paths.get("/Users/harrychan/eclipse-workspace/FingerPrintMatch/printSample/finger2.jpg"));
			candidateImage = Files.readAllBytes(Paths.get("/Users/harrychan/eclipse-workspace/FingerPrintMatch/printSample/finger1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FingerprintTemplate probe = new FingerprintTemplate().dpi(500).create(probeImage);
		
		
		
		FingerprintTemplate candidate = new FingerprintTemplate().dpi(500).create(candidateImage);
		String json = candidate.serialize();
		FingerprintTemplate template = new FingerprintTemplate()
			    .deserialize(json);
		System.out.println(json);
		double score = new FingerprintMatcher().index(probe).match(template);
		double threshold = 40;
		boolean matches = score >= threshold;
		System.out.print(matches + "");

	}

	UserDetails find(FingerprintTemplate probe, Iterable<UserDetails> candidates) {
		FingerprintMatcher matcher = new FingerprintMatcher().index(probe);
		UserDetails match = null;
		double high = 0;
		for (UserDetails candidate : candidates) {
			double score = matcher.match(candidate.template);
			if (score > high) {
				high = score;
				match = candidate;
			}
		}
		double threshold = 40;
		return high >= threshold ? match : null;
	}

}
