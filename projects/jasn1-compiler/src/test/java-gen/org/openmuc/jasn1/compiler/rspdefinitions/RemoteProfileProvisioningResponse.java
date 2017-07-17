/**
 * This class file was automatically generated by jASN1 v1.8.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import org.openmuc.jasn1.compiler.pkix1explicit88.Certificate;
import org.openmuc.jasn1.compiler.pkix1explicit88.CertificateList;
import org.openmuc.jasn1.compiler.pkix1explicit88.Time;
import org.openmuc.jasn1.compiler.pkix1implicit88.SubjectKeyIdentifier;

public class RemoteProfileProvisioningResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2);

	public InitiateAuthenticationResponse initiateAuthenticationResponse = null;
	public AuthenticateClientResponseEs9 authenticateClientResponseEs9 = null;
	public GetBoundProfilePackageResponse getBoundProfilePackageResponse = null;
	public CancelSessionResponseEs9 cancelSessionResponseEs9 = null;
	public AuthenticateClientResponseEs11 authenticateClientResponseEs11 = null;
	
	public RemoteProfileProvisioningResponse() {
	}

	public RemoteProfileProvisioningResponse(byte[] code) {
		this.code = code;
	}

	public RemoteProfileProvisioningResponse(InitiateAuthenticationResponse initiateAuthenticationResponse, AuthenticateClientResponseEs9 authenticateClientResponseEs9, GetBoundProfilePackageResponse getBoundProfilePackageResponse, CancelSessionResponseEs9 cancelSessionResponseEs9, AuthenticateClientResponseEs11 authenticateClientResponseEs11) {
		this.initiateAuthenticationResponse = initiateAuthenticationResponse;
		this.authenticateClientResponseEs9 = authenticateClientResponseEs9;
		this.getBoundProfilePackageResponse = getBoundProfilePackageResponse;
		this.cancelSessionResponseEs9 = cancelSessionResponseEs9;
		this.authenticateClientResponseEs11 = authenticateClientResponseEs11;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {
		return encode(os, true);
	}

	public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (authenticateClientResponseEs11 != null) {
			codeLength += authenticateClientResponseEs11.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 64
			os.write(0x40);
			os.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(os, codeLength);
			if (withTag) {
				codeLength += tag.encode(os);
			}
			return codeLength;
		}
		
		if (cancelSessionResponseEs9 != null) {
			codeLength += cancelSessionResponseEs9.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 65
			os.write(0x41);
			os.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(os, codeLength);
			if (withTag) {
				codeLength += tag.encode(os);
			}
			return codeLength;
		}
		
		if (getBoundProfilePackageResponse != null) {
			codeLength += getBoundProfilePackageResponse.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 58
			os.write(0x3A);
			os.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(os, codeLength);
			if (withTag) {
				codeLength += tag.encode(os);
			}
			return codeLength;
		}
		
		if (authenticateClientResponseEs9 != null) {
			codeLength += authenticateClientResponseEs9.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 59
			os.write(0x3B);
			os.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(os, codeLength);
			if (withTag) {
				codeLength += tag.encode(os);
			}
			return codeLength;
		}
		
		if (initiateAuthenticationResponse != null) {
			codeLength += initiateAuthenticationResponse.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 57
			os.write(0x39);
			os.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(os, codeLength);
			if (withTag) {
				codeLength += tag.encode(os);
			}
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		BerLength length = new BerLength();
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		codeLength += length.decode(is);
		codeLength += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 57)) {
			initiateAuthenticationResponse = new InitiateAuthenticationResponse();
			codeLength += initiateAuthenticationResponse.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 59)) {
			authenticateClientResponseEs9 = new AuthenticateClientResponseEs9();
			codeLength += authenticateClientResponseEs9.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 58)) {
			getBoundProfilePackageResponse = new GetBoundProfilePackageResponse();
			codeLength += getBoundProfilePackageResponse.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 65)) {
			cancelSessionResponseEs9 = new CancelSessionResponseEs9();
			codeLength += cancelSessionResponseEs9.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 64)) {
			authenticateClientResponseEs11 = new AuthenticateClientResponseEs11();
			codeLength += authenticateClientResponseEs11.decode(is, false);
			return codeLength;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (initiateAuthenticationResponse != null) {
			sb.append("initiateAuthenticationResponse: ");
			initiateAuthenticationResponse.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (authenticateClientResponseEs9 != null) {
			sb.append("authenticateClientResponseEs9: ");
			authenticateClientResponseEs9.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (getBoundProfilePackageResponse != null) {
			sb.append("getBoundProfilePackageResponse: ");
			getBoundProfilePackageResponse.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (cancelSessionResponseEs9 != null) {
			sb.append("cancelSessionResponseEs9: ");
			cancelSessionResponseEs9.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (authenticateClientResponseEs11 != null) {
			sb.append("authenticateClientResponseEs11: ");
			authenticateClientResponseEs11.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

