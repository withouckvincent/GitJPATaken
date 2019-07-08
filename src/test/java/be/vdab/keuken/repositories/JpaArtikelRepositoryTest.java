package be.vdab.keuken.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.keuken.domain.Artikel;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JpaArtikelRepository.class)
@Sql("/insertArtikel.sql")
public class JpaArtikelRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private JpaArtikelRepository repository;

	private long idVanTestArtikel() {
		return super.jdbcTemplate.queryForObject("select id from artikels where naam='test'", Long.class);
	}

	@Test
	public void findById() {
		Artikel artikel = repository.findById(idVanTestArtikel()).get();
		assertEquals("test", artikel.getNaam());
	}

	@Test
	public void findByOnbestaandeId() {
		assertFalse(repository.findById(-1).isPresent());
	}
}
