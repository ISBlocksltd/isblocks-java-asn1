/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.rspdefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.asn1bean.ber.*;
import com.beanit.asn1bean.ber.types.*;
import com.beanit.asn1bean.ber.types.string.*;

import com.beanit.asn1bean.compiler.pkix1explicit88.Certificate;
import com.beanit.asn1bean.compiler.pkix1explicit88.CertificateList;
import com.beanit.asn1bean.compiler.pkix1explicit88.Time;
import com.beanit.asn1bean.compiler.pkix1implicit88.SubjectKeyIdentifier;

public class AuthenticateServerRequest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 56);

	private byte[] code = null;
	public ServerSigned1 serverSigned1 = null;
	public BerOctetString serverSignature1 = null;
	public SubjectKeyIdentifier euiccCiPKIdToBeUsed = null;
	public Certificate serverCertificate = null;
	public CtxParams1 ctxParams1 = null;
	
	public AuthenticateServerRequest() {
	}

	public AuthenticateServerRequest(byte[] code) {
		this.code = code;
	}

	public AuthenticateServerRequest(ServerSigned1 serverSigned1, BerOctetString serverSignature1, SubjectKeyIdentifier euiccCiPKIdToBeUsed, Certificate serverCertificate, CtxParams1 ctxParams1) {
		this.serverSigned1 = serverSigned1;
		this.serverSignature1 = serverSignature1;
		this.euiccCiPKIdToBeUsed = euiccCiPKIdToBeUsed;
		this.serverCertificate = serverCertificate;
		this.ctxParams1 = ctxParams1;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += ctxParams1.encode(reverseOS);
		
		codeLength += serverCertificate.encode(reverseOS, true);
		
		codeLength += euiccCiPKIdToBeUsed.encode(reverseOS, true);
		
		codeLength += serverSignature1.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 55
		reverseOS.write(0x37);
		reverseOS.write(0x5F);
		codeLength += 2;
		
		codeLength += serverSigned1.encode(reverseOS, true);
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		int numDecodedBytes;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(ServerSigned1.tag)) {
			serverSigned1 = new ServerSigned1();
			vByteCount += serverSigned1.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
			serverSignature1 = new BerOctetString();
			vByteCount += serverSignature1.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(SubjectKeyIdentifier.tag)) {
			euiccCiPKIdToBeUsed = new SubjectKeyIdentifier();
			vByteCount += euiccCiPKIdToBeUsed.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(Certificate.tag)) {
			serverCertificate = new Certificate();
			vByteCount += serverCertificate.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		ctxParams1 = new CtxParams1();
		numDecodedBytes = ctxParams1.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (lengthVal < 0) {
			while (!berTag.equals(0, 0, 0)) {
				vByteCount += DecodeUtil.decodeUnknownComponent(is);
				vByteCount += berTag.decode(is);
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		} else {
			while (vByteCount < lengthVal) {
				vByteCount += DecodeUtil.decodeUnknownComponent(is);
				if (vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverSigned1 != null) {
			sb.append("serverSigned1: ");
			serverSigned1.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("serverSigned1: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverSignature1 != null) {
			sb.append("serverSignature1: ").append(serverSignature1);
		}
		else {
			sb.append("serverSignature1: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (euiccCiPKIdToBeUsed != null) {
			sb.append("euiccCiPKIdToBeUsed: ").append(euiccCiPKIdToBeUsed);
		}
		else {
			sb.append("euiccCiPKIdToBeUsed: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverCertificate != null) {
			sb.append("serverCertificate: ");
			serverCertificate.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("serverCertificate: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (ctxParams1 != null) {
			sb.append("ctxParams1: ");
			ctxParams1.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("ctxParams1: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

