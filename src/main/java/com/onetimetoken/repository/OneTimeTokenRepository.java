/**
 * 
 */
package com.onetimetoken.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetimetoken.entity.OneTimeToken;

/**
 * @author Naveenkumar Apr 26, 2025SpringBootOneTimeTokenAuth
 */

@Repository
public interface OneTimeTokenRepository extends JpaRepository<OneTimeToken, Serializable> {

	Optional<OneTimeToken> findByToken(String token);
}
